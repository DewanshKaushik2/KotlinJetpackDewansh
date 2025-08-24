package com.example.a20180101_dewanshkaushik_nycschools.models

import com.example.a20180101_dewanshkaushik_nycschools.Student
import com.example.a20180101_dewanshkaushik_nycschools.model.ApiUser

class ApiHelper {

    fun getUsers() : Student{
        return Student();
    }

    fun getApiUser() : ApiUser{
        return ApiUser();
    }
}