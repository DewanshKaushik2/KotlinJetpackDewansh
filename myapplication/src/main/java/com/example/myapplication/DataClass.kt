package com.example.myapplication

//kotlin program chalane ke liye fun class ke bahar se call karna padega


data class Person(var id: Int, var name: String, var className: String)
class Myclass(id: Int) {
    fun mydoo() {
        val sum = higherorder(2f, 3f);
        val finalsum = sum(2f, 3f)
        print(finalsum)
        "".myfunc()
    }
}

fun higherorder(first: Float, second: Float): (Float, Float) -> Float {
    return { first, second -> first + second }
}

fun String.myfunc(): String {
    return this
}

//class myclass :Person(1,"","") {
//
//}
fun main(ss: Array<String>) {
    firstMethod()
    secondMethod()
    thirdMethod()
    fourthmethod()
    val vv = Myclass(2).mydoo()
    println("" + vv + "mera wala")
}

fun thirdMethod(): IntArray {
    val a = listOf(1, 2, 3, 3, 4, 5, 5, 5, 6)
    val b = mutableListOf(1, 3, 3, 3, 4, 4, 5, 6, 6, 7)

    b.add(1)
    val setA = a.toSet()
    val setB = b.toSet()

    val intersection = setA.union(setB)

    intersection.forEach {
        println("mera hai" + it);
    }
//    print("mera hai" +intersection.toIntArray());
    return intersection.toIntArray()
}

fun secondMethod() {
    val listone = listOf(
        Person(1, "name", "class"),
        Person(2, "name", "class")
    )

    val listSecond = listOf(
        Person(3, "name", "class"),
        Person(2, "name", "class"),
        Person(4, "name", "class")
    )

    val thirdList = listone + listSecond
    println(thirdList)
//    thirdList.
    thirdList.filter {
        it.id % 2 == 0
    }
}


fun fourthmethod() {
    printType(123)    // The type of T is class kotlin.Int
    printType("Hello") // The type of T is class kotlin.String
}

inline fun <reified T> printType(value: T) {
    println(" ${T::class.java}")
}

fun firstMethod() {
    // println("hi")

    val dd = Person(2, "hi", "hi")
    dd.name
    val (xx, yy) = dd;
    println(xx)
    println(yy)

    println(dd.component1())
    println(dd.component2())

}

