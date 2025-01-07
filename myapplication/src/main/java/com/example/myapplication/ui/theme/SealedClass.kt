package com.example.myapplication.ui.theme

import androidx.lifecycle.ViewModelProvider

//kotlin program chalane ke liye fun class ke bahar se call karna padega

sealed class SealedClass {
    // A common property for all subclasses
    abstract val message: String

    // A function common to all subclasses
    fun printMessage() {
        println("Message: $message")
    }

    data class Success(var string: String)


    data class Failure(val string: String)

}

class Myclass(val string: String) {
    lateinit var name: String
    var age: Int = 0

    // Secondary constructor
    constructor(name: String, age: Int) : this(name) {
        this.name = name
        this.age = age
        this.name=string;
    }

    init {
        print(string)
    }

    fun myfunc() {
        print(string)
    }
}

fun main(ss: Array<String>) {
    // println("hi")

}

