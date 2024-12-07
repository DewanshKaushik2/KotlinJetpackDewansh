package com.example.myapplication

import kotlinx.coroutines.delay

//kotlin program chalane ke liye fun class ke bahar se call karna padega

class Demo constructor(var ss: Int) {
    init {
        hi("hellFo")
    }

    companion object {
        const val hh: Int = 0
        const val hh2: Int = 0
    }

    fun hi(hh: String) {
        println(hh)
        print(ss);
    }
}

suspend fun hello(value: String): String {
    delay(1000)
    return "data processed $value"
}

fun main(ss: Array<String>) {
    // println("hi")

}

