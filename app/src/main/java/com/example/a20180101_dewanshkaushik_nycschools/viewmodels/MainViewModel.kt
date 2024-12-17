package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20180101_dewanshkaushik_nycschools.StudentItem
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<StudentItem>>(UiState.Loading)
    val uiState: StateFlow<UiState<StudentItem>> = _uiState

    var counterState = MutableStateFlow(1)

    var loading = MutableStateFlow(false);

    val posts: MutableState<List<StudentItem>> = mutableStateOf(emptyList())

    //function to get data from server
    init {
        fetchUsers()
        startCounter()
    }

    private val _users = mutableStateListOf<StudentItem>()
    val users: List<StudentItem> = _users

    fun fetchUsers() {
        loading.value = true;
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = topHeadlineRepository.getTopHeadlines()
                response.catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                    e.printStackTrace()
                }.collect { value ->
                    //   val list
                    _uiState.value = UiState.Success<StudentItem>(value)
                    posts.value = UiState.Success<StudentItem>(value).data
                    loading.value = false;
                }
            } catch (e: Exception) {
                e.printStackTrace()
                loading.value = false;
            }
        }
    }

    fun startCounter() {
        var count = 0
        viewModelScope.launch {
            while (count < 10) {
                delay(1000)
                counterState.value = count++;
            }
        }
    }
}
