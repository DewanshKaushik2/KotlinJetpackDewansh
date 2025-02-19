package com.example.a20180101_dewanshkaushik_nycschools

import com.example.a20180101_dewanshkaushik_nycschools.models.StudentDetail
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopHeadlineRepository @Inject constructor(private val networkService: NetworkService) {

    fun getTopHeadlines(): Flow<Student> {
        return flow {
            emit(networkService.getTopHeadlines())
        }.map {
            it
        }
    }

  fun getCityDetails(): Flow<StudentDetail> {
        return flow {
            emit(networkService.getCityDetails())
        }.map {
            it
        }
    }
























    fun myMethod():Flow<String> {
        return flow<String> {
            while(true){
                delay(1000)
                emit("1")
            }
        }
    }
}