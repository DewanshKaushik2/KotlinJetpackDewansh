package com.example.myapplication


fun let() {
    // Example of using `let` for a null-safe call
    var name: String? = "John"
    val length = name?.let {
        println("The name is not null, it's $it")
        it.length // `it` refers to the non-null `name`
    }
    println("The length of the name is $length")
    name = "null"
    val  p = Person(1,"w","w")
    p.also {
        it.id=3
    }
    val nullLength = name?.let {
        // This block won't execute because name is null
        it.length
    }
    println("The length of the null name is $nullLength")
}

fun run() {
    // Example of using `run` for object configuration and calculation
    data class Person(var name: String, var age: Int)

    val person = Person("Alice", 30).run {
        // `this` refers to the Person object
        this.name = "Alicia" // or simply `name = "Alicia"`
        this.age + 5 // returns the new age
    }

    println("The person's new age is $person") // `person` holds the value 35
}

fun with() {
    // Example of using `with` to perform multiple operations
    val numbers = mutableListOf("one", "two", "three")

    with(numbers) {
        // `this` refers to the `numbers` list
        println("The list has $size elements.")
        add("four")
        println("The list now has $size elements.")
    }

    println(numbers)
}

fun apply() {
    // Example of using `apply` for object initialization
    val newPerson = Person(59, "dewansh", "").apply {
        // `this` refers to the `Person` object being created
        id = 45 // directly setting a property
        println("A new person named $name is being configured.")
    }
    println(newPerson)
}

fun also() {
    // Example of using `also` for logging
    val list = mutableListOf("A", "B", "C")
        .also {
            // `it` refers to the list
            println("The list contains $it elements before adding 'D'.")
        }
        .add("D")
    println("The list after adding 'D' is $list")
}

fun main() {
    let()
    run()
    with()
    apply()
    also()
}

