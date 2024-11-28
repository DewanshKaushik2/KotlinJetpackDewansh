package com.example.myapplication

//kotlin program chalane ke liye fun class ke bahar se call karna padega

//class Sorting constructor( ff:String) {
class Sorting(val ff: String) {//we need to declare variable in constructor if we want to access it in
//    method
init {
    hi(ff)
}

    fun hello() {
        println(ff)
    }

    lateinit var string: String

    companion object {
        const val hh: Int = 0
        const val hh2: Int = 0
    }

    fun hi(hh: String) {
        println(hh)
    }
}

fun sorting() {
    val list = intArrayOf(1, 2, 4, 3);
    for (i in 0 until list.size) {
        for (j in i until list.size) {
            var k = 0
            if (list.get(i) > list.get(j)) {
                k = list.get(i)
                list[i] = list[j]
                list[j] = k
            }
        }
    }
    for (i in list) {
        print(i.toString() + " ")
    }

}

fun main(ss: Array<String>) {
    // println("hi")
    sorting()
    Sorting("hi")
}

