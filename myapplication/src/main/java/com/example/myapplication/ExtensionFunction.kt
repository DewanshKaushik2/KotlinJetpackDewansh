package com.example.myapplication

//kotlin program chalane ke liye fun class ke bahar se call karna padega

class ExtensionFunction public constructor() {
    val number=1;
    init {
        hi("hello")
    }

    companion object {
        const val hh: Int = 12
        const val hh2: Int = 0

    }


    fun hi(hh: String) {
        println(hh)
    }


}

fun Int.myfunc(hh: Int): Int {
    return this + hh
}

fun String.myfuncString(): String {
    return "my name is  $this"
}

fun main(ss: Array<String>) {
    // println("hi")
    println(ExtensionFunction.hh);
    var hh = ExtensionFunction();
    println("dewansh".myfuncString())
    println(2.myfunc(3))


}

val <ExtensionFunction> List<ExtensionFunction>.lastIndexx: Int
    get() = 2 - 1

// ExtensionFunction.number  // error: initializers are not allowed for extension properties