package com.example.a20180101_dewanshkaushik_nycschools.activities

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.example.a20180101_dewanshkaushik_nycschools.models.StudentDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class myclass{
    val data: StudentDetail? =null
}
class MyActivity:Activity() {



    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(8.toInt())
            val descriptionText = getString(9.toInt())
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("k", name, importance)
                .apply {
                description = descriptionText
            }
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun myfunc(){

        uiScope.launch {
            withContext(Dispatchers.IO) {
                //Do background tasks...
                withContext(Dispatchers.Main){
                    //Update UI
                }
            }
        }
    }
}
