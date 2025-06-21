package com.example.myapplication.linkedlist

class FrequencyCount {


}

fun myfunc() {
    val list = listOf(1, 1, 1, 7, 7, 4, 8, 4, 7, 9, 7, 2, 3, 8)
    val myset = mutableSetOf<Int>()
    val finallist = list.filter {
        it % 3 == 0
    }
    for (i in finallist) {
        print(" " + i + " ")
    }
    val mylist = list.filterNotNull()
    println()
    for (i in mylist) {
        print(" " + i + " ")
    }

}

fun main() {
    val gg = myfunc();

}