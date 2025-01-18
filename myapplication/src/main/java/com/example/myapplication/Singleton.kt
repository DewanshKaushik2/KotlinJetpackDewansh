package com.example.myapplication

object Singletond {
    var aa=9
    fun aand(){
print("aand")
    }


}

fun main(){
  //  var ss = Singleton()
   Singletond.aand()
   Singletond.aa
}