package com.example.a20180101_dewanshkaushik_nycschools.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class BaseActivity : AppCompatActivity() {
    val MYTAG=BaseActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(MYTAG,"oncreate")
    }

    override fun onResume() {
        super.onResume()
        Log.e(MYTAG,"onResume")

    }

    override fun onStart() {
        super.onStart()
        Log.e(MYTAG,"onStart")

    }

    override fun onPause() {
        super.onPause()
        Log.e(MYTAG,"onPause")

    }


    override fun onStop() {
        super.onStop()
        Log.e(MYTAG,"onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(MYTAG,"onDestroy")

    }
}