package com.example.a20180101_dewanshkaushik_nycschools.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import javax.inject.Singleton
import kotlin.reflect.KClass


@Singleton
class ViewModelProviderFactory<T : ViewModel>(
    private val kClass: KClass<T>,
    private val creator: () -> T,
//    val topHeal:TopHeadlineRepository
) : ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(kClass.java)) return creator() as T
        throw IllegalArgumentException("Unknown class name")
    }

//    @Suppress("UNCHECKED_CAST")
//    @Throws(IllegalArgumentException::class)
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            return MainViewModel() as T
//        }
//        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
//    }
}