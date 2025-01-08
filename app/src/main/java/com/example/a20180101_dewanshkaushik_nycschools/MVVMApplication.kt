package com.example.a20180101_dewanshkaushik_nycschools

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MVVMApplication : Application() {

//    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
     //   injectDependencies()
    }

   /* private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }*/

}