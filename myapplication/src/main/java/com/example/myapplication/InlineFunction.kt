package com.example.myapplication

import com.example.myapplication.ui.theme.SealedInterface

//kotlin program chalane ke liye fun class ke bahar se call karna padega

class InlineFunction : SealedInterface {
    init {
        hi("hello")
    }

    companion object {
        const val hh: Int = 0
        const val hh2: Int = 0

    }

    override inline fun hi(hh: String) {
        println(hh)
    }
}

inline fun highOrderdd(a: Int): (Int) -> Int {
    return { b -> a * b }
}

fun main(ss: Array<String>) {
    // println("hi")
    val fff = highOrderdd(2)
    println(fff(3))
    val hh = mutableListOf(7, 6, 4, 9, 7, 3, 6, 7)
//example of for loop
    for (i in 0 until hh.size step 2) {
        println("" + i + " " + hh.get(i))
    }
    var gg = -3;
    while (gg < 5) {
        println(gg)
        gg++
    }
    var ff = 3
    when (ff) {
        0 -> println("hi")
        1 -> println("hi")
        2 -> println("hi")
        3 -> println("3")
        is Int -> println("int hai")
    }
}

