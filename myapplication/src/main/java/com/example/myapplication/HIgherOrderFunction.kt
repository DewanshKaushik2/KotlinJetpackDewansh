package com.example.myapplication

//kotlin program chalane ke liye fun class ke bahar se call karna padega

class HIgherOrderFunction public constructor(val gg:String) {
    init {
        //d    hi("hello")
        print(gg)
    }

    companion object {
        const val hh: Int = 0
        const val hh2: Int = 0
    }

    fun hi(hh: String) {
        println("inner")
        println(hh)
        print(gg)
    }
}

fun HIgherOrderFunction.hi(): HIgherOrderFunction {
    println("outer")
    return HIgherOrderFunction("")
}

inline fun addValue(): (Float, Float) -> Float {
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
    val func = addValue()
    println(func(2.0f, 3f))
    println("my name is dewansh".addValue())
    var ss = HIgherOrderFunction("")
    println(ss.hi())

    val value: Int? = null
    val name: String? = value as? String

}

