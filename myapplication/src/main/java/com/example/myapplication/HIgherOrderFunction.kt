package com.example.myapplication

//kotlin program chalane ke liye fun class ke bahar se call karna padega

class HIgherOrderFunction public constructor() {
    init {
        //d    hi("hello")
    }

    companion object {
        const val hh: Int = 0
        const val hh2: Int = 0

    }

    fun hi(hh: String) {
        println("inner")
        println(hh)
    }
}

fun HIgherOrderFunction.hi(): HIgherOrderFunction {
    println("outer")
    return HIgherOrderFunction()
}

inline fun addValue(value: Int, b: Int): (Int, Int) -> Int {
    return { a, b -> a + b }
}

fun myNextValue() {
    return;
}

fun String.addValue(): String {
    return "hello i am $this"
}

fun main(ss: Array<String>) {
    //  println("hi")
    val func = addValue(2, 3)
    println(func(2, 3))
    println("my name is dewansh".addValue())
    var ss = HIgherOrderFunction()
    println(ss.hi())

    val value: Int? = null
    val name: String? = value as? String

}

