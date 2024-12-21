package com.example.myapplication

class List<T> {

}
var myvalue = null
var mystring: String? = null
val mm: String by lazy {
    "value"
}

fun main() {
    mystring.let {
        "hi"
    }
//    println(mystring!!.toString())
    println(mystring?.toString())
    var k = mystring ?: "bar"
    println(k)
    //   print(mm)
    //viewmodel side
//    return flow<String> {
//        emit("")
//    }

    //1. we need to fetch the data
    //2. we need to show loader
    //3. write response in file
    //4. show response on ui


    //1. we will start a coroutine to start fetching the data from server we will use
//    worker launch(Dispatcher.io) coroutine for this task.
    // 2at the start of this coroutine we will show the loader.
    //3. we will start a coroutine to write the response of file and we will use async(Dispatcher.Default)
    // to write this on file
    //4.  we will start the launch corutine of async(Dispatcher.IO) to fetch the data from file and show
    // 5. to the ui(Dispatcher.Main)
    // close the loader


//    viewside
    //   viewmodel.flowObject.collect() {
    // we will get it from this object we will get our data.
    //  }


    var list = mutableListOf("1", 2, 3,2.3)
    var integerList = intArrayOf(1, 2, 3, 4, 5, 6)
    var secondList = intArrayOf()
    //1357
    //2 6 10 14
   var thdd= integerList.filter { it ->
        it % 2 != 0
    }

    for (i in thdd){
        println(i)
    }

    var thirdLIst = intArrayOf()
    for(i in secondList){
        var k = i*2;

    }


}