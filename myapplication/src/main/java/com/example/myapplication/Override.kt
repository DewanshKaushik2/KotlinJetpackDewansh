package com.example.myapplication

open class Override {
    open fun showMessage() {
        println("parent")
    }
}

interface SecondParent {
}

interface ThirdParent {

}

class Child : Override(), SecondParent, ThirdParent {
    override fun showMessage() {
        println("child")
    }
}

fun main() {
    val parent: Override = Child();
    parent.showMessage();

}
