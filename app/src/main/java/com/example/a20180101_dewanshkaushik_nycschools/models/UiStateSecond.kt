package com.example.a20180101_dewanshkaushik_nycschools.models

import com.example.a20180101_dewanshkaushik_nycschools.Student

sealed interface UiStateSecond<out T>{

    data class Success<T>(val data: StudentDetail) : UiStateSecond<T>

    data class Error(val message: String) : UiStateSecond<Nothing>

    object Loading : UiStateSecond<Nothing>

}


