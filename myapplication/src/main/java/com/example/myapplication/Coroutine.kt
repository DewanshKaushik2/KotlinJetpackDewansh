package com.example.myapplication

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Coroutine {
    init {
        hi("hellFo")
    }

    companion object {
        const val hh: Int = 0
        const val hh2: Int = 0
    }

    fun hi(hh: String) {
        println(hh)
        // print(ss);
    }
}

fun myfunc() {

}

suspend fun helloss(value: String): String {
    delay(1000)
    return "data processed $value"
}

fun firstCoroutine() {
    println("before")

    GlobalScope.launch {
        val myvalue = async {
            helloss("hi")
        }
        println(myvalue.await())
    }
    println("after")
}

fun secondCoroutine() {
    runBlocking {
        println("start")

        val job = GlobalScope.async {
            delay(1000)
            println("coroutine completed")
            1
        }
        //   val result = job.join()
        println("End with ")
    }
    println("end")
}

@OptIn(DelicateCoroutinesApi::class)
fun main(ss: Array<String>) {
    firstCoroutine()
    secondCoroutine();
    thirdCoroutine();

}

fun thirdCoroutine() {
    runBlocking {
        println("start")
        val context =
            SupervisorJob() + Dispatchers.Default + CoroutineName("test") + CoroutineExceptionHandler { context, throwable ->
            }
        val scope = CoroutineScope(context)
        scope.launch {
        }
        scope.async {
        }
        val job = scope.async {
            delay(1000)
            println("Coroutine completed")
            1
        }
        job.isActive


    }
}