package com.example.myapplication.linkedlist

// kotlin program chalane ke liye fun class ke bahar se call karna padega

class MergeSortedArray public constructor() {
    init {
        hi("hello")
    }

    companion object {
        const val hh: Int = 2
        const val hh2: Int = 0
    }

    fun hi(hh: String) {
        println(hh)
    }
}

fun mergeSortedArrays(array1: IntArray, array2: IntArray): IntArray {
    val result = IntArray(array1.size + array2.size)
    var i = 0;
    var j = 0;
    var k = 0;

    while (i < array1.size && j < array2.size) {
        if (array1[i] < array2[j]) {
            result[k++] = array1[i++]
        } else {
            result[k++] = array2[j++]
        }
    }

    while (i < array1.size) {
        result[k++] = array1[i++]
    }
    while (j < array2.size) {
        result[k++] = array2[j++]
    }
    return result;
}

// Usage
fun main() {
    val array1 = intArrayOf(1, 3, 5, 7)
    val array2 = intArrayOf(2, 4, 6, 8)
    val mergedArray = mergeSortedArrays(array1, array2)
    println(mergedArray.joinToString(", "))  // Output: 1, 2, 3, 4, 5, 6, 7, 8
}

fun mainn(ss: Array<String>) {
    println(MergeSortedArray.hh)
}

