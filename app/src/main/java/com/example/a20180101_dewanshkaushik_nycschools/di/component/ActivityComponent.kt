package com.example.a20180101_dewanshkaushik_nycschools.component

import com.example.a20180101_dewanshkaushik_nycschools.MainActivity
import com.example.a20180101_dewanshkaushik_nycschools.di.ActivityScope
import com.example.a20180101_dewanshkaushik_nycschools.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}