package com.example.myapplication.linkedlist

class MultiplyEachIndex {


}

fun main() {
    print("")
    mera()
}

fun mera() {
    var list = mutableListOf<String>()
    list.add("hi")
    println(list.get(0))

    var list2 = ArrayList<String>()
    list2.add("hi")
    println(list2.get(0))

    val array = intArrayOf(1,2,3,4,5)
    println(array[4])

    // list[0] = ""
    list.forEach {
        println(it)
    }
    /*list.set(1, "")
    list.get(1)
*/
}
