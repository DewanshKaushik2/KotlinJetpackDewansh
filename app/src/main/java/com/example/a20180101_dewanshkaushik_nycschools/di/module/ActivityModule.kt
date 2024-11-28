package com.example.a20180101_dewanshkaushik_nycschools.module


import android.content.Context
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import com.example.a20180101_dewanshkaushik_nycschools.di.ActivityContext
import com.example.a20180101_dewanshkaushik_nycschools.di.ViewModelProviderFactory
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: ComponentActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): MainViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(MainViewModel::class) {
                MainViewModel(topHeadlineRepository)
            })[MainViewModel::class.java]
    }

//    @Provides
//    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
//        return ViewModelProvider(activity,
//            ViewModelProviderFactory(TopHeadlineViewModel::class) {
//                TopHeadlineViewModel(topHeadlineRepository)
//            })[TopHeadlineViewModel::class.java]
//    }
}