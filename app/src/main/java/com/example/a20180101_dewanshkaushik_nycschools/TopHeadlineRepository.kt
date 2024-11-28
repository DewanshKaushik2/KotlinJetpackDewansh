package com.example.a20180101_dewanshkaushik_nycschools

import kotlinx.coroutines.flow.Flow
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

}