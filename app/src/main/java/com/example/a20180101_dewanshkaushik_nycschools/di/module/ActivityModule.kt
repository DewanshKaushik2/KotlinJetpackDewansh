package com.example.a20180101_dewanshkaushik_nycschools.module


import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import com.example.a20180101_dewanshkaushik_nycschools.activities.MainActivity
import com.example.a20180101_dewanshkaushik_nycschools.di.ActivityContext
import com.example.a20180101_dewanshkaushik_nycschools.di.MainActivityQualifier
import com.example.a20180101_dewanshkaushik_nycschools.di.MyActivityQualifier
import com.example.a20180101_dewanshkaushik_nycschools.di.ViewModelProviderFactory
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.FlowViewModel
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ActivityModule {

/*
    @ActivityContext
    @Provides
    fun provideContext(@ApplicationContext activity: AppCompatActivity): AppCompatActivity {
        return activity
    }
*/

/*

      @Provides
      fun provideTopHeadlineViewModel(@ActivityContext context: AppCompatActivity
       , topHeadlineRepository: TopHeadlineRepository): MainViewModel {
          return ViewModelProvider(context,
              ViewModelProviderFactory(MainViewModel::class) {
                  MainViewModel(topHeadlineRepository)
              }
          )[MainViewModel::class.java]
    }

    @Provides
    fun provideFlowViewModel(activity: AppCompatActivity,
                             topHeadlineRepository: TopHeadlineRepository): FlowViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(FlowViewModel::class) {
                FlowViewModel(topHeadlineRepository)
            }
        )[FlowViewModel::class.java]
    }
*/

    @Provides
    @MainActivityQualifier
    fun provideMainActivity(activity: Activity): AppCompatActivity {
        if (activity is AppCompatActivity) {
            return activity
        } else {
            throw IllegalArgumentException("Provided activity is not an instance of MainActivity")
        }
    }

    @Provides
    @MyActivityQualifier
    fun provideMyActivity(activity: Activity): AppCompatActivity {
        if (activity is AppCompatActivity) {
            return activity
        } else {
            throw IllegalArgumentException("Provided activity is not an instance of MainActivity")
        }
    }


    //    @InstallIn(SingletonComponent::class)
//    @Module
//    class AppModule {
//    @Singleton
//    @Provides
//    fun provideMoviesRepository(moviesRepositoryImpl: TopHeadlineRepository): TopHeadlineRepository {
//        return moviesRepositoryImpl
//    }

    //    }
}