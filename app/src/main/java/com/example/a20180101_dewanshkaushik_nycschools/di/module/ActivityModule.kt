package com.example.a20180101_dewanshkaushik_nycschools.module


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import com.example.a20180101_dewanshkaushik_nycschools.di.ActivityContext
import com.example.a20180101_dewanshkaushik_nycschools.di.ViewModelProviderFactory
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.FlowViewModel
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
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
      @Provides
      fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): MainViewModel {
          return ViewModelProvider(activity,
              ViewModelProviderFactory(MainViewModel::class) {
                  MainViewModel(topHeadlineRepository)
              }
          )[MainViewModel::class.java]
    }

    @Provides
    fun provideFlowViewModel(topHeadlineRepository: TopHeadlineRepository): FlowViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(FlowViewModel::class) {
                FlowViewModel(topHeadlineRepository)
            }
        )[FlowViewModel::class.java]
    }
}