package com.example.myapplication

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

@OptIn(DelicateCoroutinesApi::class)
fun main(ss: Array<String>) {
    println("before")

    GlobalScope.launch {
      val myvalue=  async {
            helloss("hi")
        }
        println(myvalue.await())
    }
    println("after")


}

