package com.example.a20180101_dewanshkaushik_nycschools

import android.app.Application
import com.example.a20180101_dewanshkaushik_nycschools.component.ApplicationComponent
import com.example.a20180101_dewanshkaushik_nycschools.component.DaggerApplicationComponent
import com.example.a20180101_dewanshkaushik_nycschools.module.ApplicationModule

class MVVMApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}