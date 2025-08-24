package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import com.example.a20180101_dewanshkaushik_nycschools.Student
import com.example.a20180101_dewanshkaushik_nycschools.model.ApiUser

sealed interface UiState<out T>{

    data class Success<T>(val data: Student) : UiState<T>

    data class Error(val message: String) : UiState<Nothing>

    object Loading : UiState<Nothing>

    data class Success2<T>(val data: ApiUser) : UiState<T>

}


