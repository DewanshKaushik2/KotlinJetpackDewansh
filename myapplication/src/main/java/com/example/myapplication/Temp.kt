//
class Temp {

}

fun String.myfunc(myname:String) {
    println("hello " + this)
    println(myname)
}

fun add(a: Int, b: Int): (Int, Int) -> Int {
    return { a, b -> a + b }
}

fun main() {
    val sum = add(2, 3)
    val gg = sum(2, 3)
    println(gg)
    "dewansh".myfunc("hh")

}

//fun add( a:Int, b:Int) :(Int,Int)->Int{
//    return {a,b -> a+b}
//}
//
//fun main() {
//
//}
