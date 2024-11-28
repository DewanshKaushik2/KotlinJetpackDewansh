package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20180101_dewanshkaushik_nycschools.StudentItem
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<StudentItem>>(UiState.Loading)
    val uiState: StateFlow<UiState<StudentItem>> = _uiState

    val posts: MutableState< List < StudentItem >> = mutableStateOf(emptyList())
//  val posts: MutableState< List < Post >> = mutableStateOf(emptyList())

    //function to get data from server
    init {
        fetchUsers()
    }

    private val _users = mutableStateListOf<StudentItem>()
    val users: List<StudentItem> = _users

    public fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = topHeadlineRepository.getTopHeadlines()
                response.catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                    e.printStackTrace()
                }.collect { value ->
//                    _uiState.value=UiState.Success(value)
                    //   val list
                    _uiState.value = UiState.Success<StudentItem>(value)
                    posts.value = UiState.Success<StudentItem>(value).data

                    run {
                        //     posts = value.toList() as ArrayList<StudentItem>
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getData() {

//        viewModelScope.launch {
//            topHeadlineRepository.getTopHeadlines()
//                .catch { e ->
//                    _uiState.value = UiState.Error(e.toString())
//                    var ff = mutableListOf<StudentItem>()
//                    //     posts.value = Stu
//
//                }
//                .collect {
//                    //  _uiState.value = UiState.Success(it)
//                    //d _uiState.value = mutableListOf<StudentItem>()
//                }
//        }
    }


}
