package com.example.myapplication.linkedlist


fun main() {

    var mystring = "dewansh"

    var mychararray = mystring.toCharArray()
    var finalArray = CharArray(mychararray.size);
    var counter = 0;

    for (i in mychararray.size - 1 downTo 0) {
        finalArray[counter] = mychararray[i]
        //    println(finalArray[counter])
        counter++;
    }

    for (i in finalArray) {
        //   print(i)
    }
    removeduplicatefromsortedarray();

}

fun removeduplicatefromsortedarray() {
    //    val array = Array(2) { IntArray(3) }
        val rows = 3
        val cols = 4
        val twoDArray = Array(rows) { Array(cols) { 0 } }
        // A 3x4 array initialized with 0s

        // Accessing and modifying elements
        twoDArray[1][2] = 5
        println(twoDArray[1][2]) // Output: 5

        // Print the array
        for (i in 0..twoDArray.size-1) {
            var temp=twoDArray.get(i)
            for (j in 0..temp.size - 1) {
                println(9 * 9)
            }
        }
}
