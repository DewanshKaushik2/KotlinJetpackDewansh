package com.example.a20180101_dewanshkaushik_nycschools

import com.example.a20180101_dewanshkaushik_nycschools.models.StudentDetail
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

   // @Headers("X-Api-Key: $API_KEY")
    @GET("s3k6-pzi2.json")
    suspend fun getTopHeadlines(): Student

    @GET("f9bf-2cp4.json")
    suspend fun getCityDetails(): StudentDetail

}