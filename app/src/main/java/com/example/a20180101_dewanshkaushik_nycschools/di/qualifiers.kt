package com.example.a20180101_dewanshkaushik_nycschools.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppllicationContext

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

//
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainActivityQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MyActivityQualifier