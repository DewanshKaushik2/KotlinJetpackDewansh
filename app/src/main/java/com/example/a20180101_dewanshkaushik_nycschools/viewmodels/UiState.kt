package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import com.example.a20180101_dewanshkaushik_nycschools.Student

sealed interface UiState<out T>{

    data class Success<T>(val data: Student) : UiState<T>

    data class Error(val message: String) : UiState<Nothing>

    object Loading : UiState<Nothing>

}


