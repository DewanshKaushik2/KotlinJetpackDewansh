package com.example.a20180101_dewanshkaushik_nycschools.module

import android.content.Context
import com.example.a20180101_dewanshkaushik_nycschools.MVVMApplication
import com.example.a20180101_dewanshkaushik_nycschools.NetworkService
import com.example.a20180101_dewanshkaushik_nycschools.di.ApplicationContext
import com.example.a20180101_dewanshkaushik_nycschools.di.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
    object ApplicationModule/*private val application: MVVMApplication*/ {

    @ApplicationContext
    @Provides
    fun provideContext(application: MVVMApplication): Context {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://data.cityofnewyork.us/resource/"

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    //creation of retrofit instance which we will use for network request.
    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkService::class.java)
    }

}