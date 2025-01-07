package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20180101_dewanshkaushik_nycschools.StudentItem
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import com.example.a20180101_dewanshkaushik_nycschools.models.StudentDetail
import com.example.a20180101_dewanshkaushik_nycschools.models.StudentDetailItem
import com.example.a20180101_dewanshkaushik_nycschools.models.UiStateSecond
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FlowViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {

    val events = MutableSharedFlow<String>()

    var count = 0

    // Emit events
    suspend fun emitEvent(event: String) {
       // while (count<50) {
            events.emit(event.toString())
         //   delay(1000)
          //  count++;
     //   }
    }
    var loading = MutableStateFlow(false);
    private val _uiState = MutableStateFlow<UiStateSecond<StudentDetail>>(UiStateSecond.Loading)
    val uiState: StateFlow<UiStateSecond<StudentDetail>> = _uiState
    val posts: MutableState<List<StudentDetailItem>> = mutableStateOf(emptyList())
    //loading
    var counterState = MutableStateFlow(1)

    //function to get data from server
    init {
        fetchUsers()
    }

    fun fetchUsers() {
        //   val coldFlow: Flow<Int> = hotToColdFlow(hotFlow)

        loading.value = true;
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = topHeadlineRepository.getCityDetails()
                response.catch { e ->
                    _uiState.value = UiStateSecond.Error(e.toString())
                    loading.value = false;
                    e.printStackTrace()
                }.collect { value ->
                    //   val list
                    _uiState.value = UiStateSecond.Success(value)
                    posts.value = UiStateSecond.Success<StudentDetail>(value).data
                    loading.value = false;
                }
            } catch (e: Exception) {
                e.printStackTrace()
                loading.value = false;
            }
        }
    }
}
