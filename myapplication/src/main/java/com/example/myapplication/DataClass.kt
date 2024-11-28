package com.example.myapplication

//kotlin program chalane ke liye fun class ke bahar se call karna padega

data class DataClass(var name:String,var className: String) {

}

fun main(ss: Array<String>) {
   // println("hi")
val dd = DataClass("hi","hi")
    dd.name
    val(xx,yy)=dd;
    println(xx)
    println(yy)

    println( dd.component1())
    println( dd.component2())
}

