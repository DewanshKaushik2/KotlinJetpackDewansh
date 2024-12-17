package com.example.myapplication

class Delegation

interface Printer {
    fun printMessage(message: String)
}

class ConsolePrinter : Printer {
    override fun printMessage(message: String) {
        println("Printing: $message")
    }
}

class Logger(private val printer: Printer) : Printer by printer {
    override fun printMessage(message: String) {
        println("Logging message: $message")
        printer.printMessage(message)
    }

}

fun main() {
    val consolePrinter = ConsolePrinter()
    val logger = Logger(consolePrinter)

    logger.printMessage("Hello, Kotlin!") // Output: Logging message: Hello, Kotlin! \n Printing: Hello, Kotlin!



}

