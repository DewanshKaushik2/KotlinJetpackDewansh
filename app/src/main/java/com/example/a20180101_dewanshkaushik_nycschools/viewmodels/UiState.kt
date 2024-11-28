package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

sealed interface UiState<out T>{

    data class Success<T>(val data: T) : UiState<T>

    data class Error(val message: String) : UiState<Nothing>

    object Loading : UiState<Nothing>

}


