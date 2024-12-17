package com.example.myapplication

import java.util.Collections

open class MyFile {

    val myvar by lazy {
        "xx"
    }

    fun add(a: Int): Unit {

    }

    fun add(a: Int, b: Int): Unit {

    }

    fun add(a: Int, b: Float): String {
        return ""
    }

    fun add(a: Int, b: String): Unit {

    }

    open fun add(a: Int, b: String, c: Int) {
        println("from parent")
    }
}

class secondclass : MyFile() {
    override fun add(a: Int, b: String, c: Int) {
        println("from child")
    }
}


fun main(array: Array<String>) {
    var hh: MyFile = secondclass()
    hh.add(1, "", 2);

    if (hh is secondclass) {
        println("second class")
    } else {
        println("not a second class")
    }

    println("hi")

    var arrayOf = mutableListOf(1, 3, 5, 7, 8);
    var secondList: Array<Int>
    for (i in 1..8) {
        for (j in 0..arrayOf.size) {
            if (arrayOf.contains(i)) {
                continue;
            } else {
                arrayOf.add(i);
            }
        }
    }
    Collections.sort(arrayOf)
    println(arrayOf)
    var flag = 1;
//    do {
//        print(flag)
//        flag++;
//    }while (flag<=5)
//    while(flag<=5){
//        print(flag)
//        flag++
//    }
    Int
    for (i in 5.downTo(1)) {
        print(i)
    }


}
