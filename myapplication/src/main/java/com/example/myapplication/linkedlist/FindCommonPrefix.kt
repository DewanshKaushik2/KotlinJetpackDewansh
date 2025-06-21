package com.example.myapplication.linkedlist


fun getCommonPrefix(strings: List<String>) {


}

fun twoSum(): IntArray {
    val myarray = intArrayOf(12, 16, 23, 5, 5, 9, 8)
    val i = myarray.contains(8)
    myarray.indexOf(8)
    println(i)
    val target = 28
    for (i in 0..myarray.size - 1) {
        val ihh = myarray[i];
        for (j in i..myarray.size - 1) {
            if (myarray[i] + myarray[j] == target) {
                println("success " + i + " " + j + " ")
                return intArrayOf(i, j);
            } else {
                //println("error")
            }
        }
    }
    return IntArray(0);
}

fun findSum() {
    val target = 28
    val myarray = intArrayOf(12, 16, 23, 5)
    val i = myarray.contains(8)
    myarray.indexOf(8)
    println(i)
    val temp=0
    for(i in 0..myarray.size-1) {
        val temp = target - myarray[i]
        if (myarray.contains(temp)) {
            val j=   myarray.indexOf(temp)
            println("sum of ${myarray[i]} + ${myarray[j]} +$target")
        //    break;
        }

    }
    println(myarray.indexOf(temp))
}

// Usage
fun main() {
    findSum()
/*
    for (i in twoSum()) {
        print(" " + i + ", ")
    }
*/

    /*    val strings = listOf("flower", "flow", "flight")
        val commonPrefix = getCommonPrefix(strings)
        println("Common Prefix: $commonPrefix") // Output: "fl"*/
}