package com.example.myapplication

open class zipfunction {


}

fun main(){
    val list1 = listOf(1, 2, 3, 4, 5, 6, 7)
    val list2 = listOf("a", "b", "c")
//    val list3 = listOf("a", "b", "c")

//    val zipped = list1.zip(list2).zip(list3)
    val zipped = list1.zip(list2)
    println(zipped)  // Output: [(1, a), (2, b)]


}