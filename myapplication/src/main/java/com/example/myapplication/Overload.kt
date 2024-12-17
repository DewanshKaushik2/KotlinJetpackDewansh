package com.example.myapplication

class Overload {}

fun add(a: Int): Unit {

}

fun add(a: Int, b: Int): Unit {

}

fun add(a: Int, b: Float): String {
    return ""
}

fun add(a: Int, b: String): Unit {

}

fun add(a: Int, b: String, c: Int) {
    println("from parent")
}