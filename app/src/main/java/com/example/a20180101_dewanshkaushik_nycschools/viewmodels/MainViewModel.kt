package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20180101_dewanshkaushik_nycschools.StudentItem
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class MainViewModel(val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<StudentItem>>(UiState.Loading)

    val uiState: StateFlow<UiState<StudentItem>> = _uiState

    //function to get data from server
    init {
        //    getData()
//        topHeadlineRepository.getTopHeadlines()
    }

    //    val posts: MutableState<StudentItem> = mutableStateOf(emptyList())
    private val _posts = MutableStateFlow<List<StudentItem>>(emptyList())

    // var : StateFlow<List<StudentItem>> = _posts
    var posts = ArrayList<StudentItem>()

    private val _users = mutableStateListOf<StudentItem>()
    val users: List<StudentItem> = _users

    public fun fetchUsers() {
//        viewModelScope.launch {
//            try {
//                val response = topHeadlineRepository.getTopHeadlines()
//                response.collect { value ->
//                    run {
//                        posts = value.toList() as ArrayList<StudentItem>
//                    }
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
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
