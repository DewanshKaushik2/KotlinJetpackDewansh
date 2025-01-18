package com.example.myapplication

import java.util.Collections

class Loops {
}

fun main(array: Array<String>) {
    var hh: MyFile = secondclass()
    hh.add(1, "", 2)

    if (hh is secondclass) {
        println("second class")
    } else {
        println("not a second class")
    }

    println("hi")

    var arrayOf = mutableListOf(1, 3, 5, 7, 8);
    var secondList: Array<Int>
    for (i in 1..8) {
        for (j in 0..arrayOf.size) {
            if (arrayOf.contains(i)) {
                continue;
            } else {
                arrayOf.add(i);
            }
        }
    }
    Collections.sort(arrayOf)
    println(arrayOf)
    // do while
    var flag=1;
    do {
        print(flag)
        flag++;
    }while (flag<=5)
    //while loop
    flag=0
    while(flag<=5){
        print(flag)
        flag++
    }
    // down to
    for(i in 5.downTo(1)){
        print(i)
    }
    // down to
    for(i in 5 downTo 1){
        print(i)
    }
    // step
    for(i in 0..5 step 1){
        print(i)
    }

    for (i in 0..3){

    }
}