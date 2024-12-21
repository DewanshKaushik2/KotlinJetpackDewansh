package com.example.myapplication

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//kotlin program chalane ke liye fun class ke bahar se call karna padega

class Sum public constructor() {
    init {
        hi("hello")
    }
//
    companion object {
        const val hh: Int = 0
        const val hh2: Int = 0

    }

    fun hi(hh: String) {
        println(hh)
    }
}

fun sum(a: Int, b: Int) {
    println(a + b)
}

fun main(ss: Array<String>) {
    // println("hi")
    sum(1, 2)
    myfunction()
}

fun myfunction() {
    runBlocking {
        launch {
            delay(1000)
            helloss("hi-launch")
        }
        async {
            delay(500)
            helloss("hi-async")
        }
    }

}