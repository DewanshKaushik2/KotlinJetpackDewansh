package com.example.a20180101_dewanshkaushik_nycschools.ui.composables

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


open class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vmp = ViewModelProvider(this)
        val vm = vmp.get(MainViewModel::class.java)
        // awaitAllMethod()
        // seriesCall()
        supervisorExample()
        setContent {
            FormScreen(this)
        }
    }

    suspend fun myfunc() {
        suspendCoroutine<Unit> { continuation ->
            continuation.resume(Unit)

        }
    }

    private fun supervisorExample() {
        val job = SupervisorJob()
        val scope = CoroutineScope(job + Dispatchers.IO)

        scope.launch {
            val first = async { firstFunction() }
//            val exceptions = async { sendException() }
            val second = async { secondFunction() }
            try {
                throw RuntimeException("Child 1 failed!") // Failure here doesn't cancel Child 2
            } catch (e: Exception) {
                e.printStackTrace()
            }

            println(first.await())
//            println(exceptions.await())
            println(second.await())
        }

    }

    fun sendException(): Exception {
        throw Exception()
    }

    var TAG = CoroutineActivity::class.java.name
    public fun saveDatainApi(string: String) {
        Log.e(TAG, string)
    }

    private fun seriesCall() {
        println("before")
        lifecycleScope.launch {
            val firstresult = async { firstFunction() }
            val secondresult = async { secondFunction() }
            println(firstresult.await())
            println(secondresult.await())
        }
        println("after")
    }

    fun awaitAllMethod() {
        GlobalScope.launch {
            val myvalue = listOf(
                async {
                    secondFunction()
                },
                async {
                    firstFunction()
                })
            println(myvalue.awaitAll())
        }
        println("after")
    }

    suspend fun firstFunction(): String {
        while (true) {
            return "first method"
            delay(1000)
        }
    }

    suspend fun secondFunction(): String {
        while (true) {
            return "second method"
            delay(1000)
        }
        val floww=flow{emit(1)}
      val ff=  MutableSharedFlow<Int>()
        val dd= MutableStateFlow("m");
    }


}