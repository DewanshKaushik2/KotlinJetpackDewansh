package com.example.myapplication.ui.theme

//kotlin program chalane ke liye fun class ke bahar se call karna padega

sealed class SealedClass  {
    // A common property for all subclasses
    abstract val message: String

    // A function common to all subclasses
    fun printMessage() {
        println("Message: $message")
    }
}

fun main(ss: Array<String>) {
   // println("hi")

}

