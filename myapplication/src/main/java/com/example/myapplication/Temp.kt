//
class Temp {

}

fun String.myfunc(myname: String) {
    println("hello " + this)
    println(myname)
}

fun add(a: Int, b: Int): (Int, Int) -> Int {
    return { a, b -> a + b }
}

data class Patient(var className: String)

fun main() {
    val lambda = { a: Int, b: Int -> a + b }
    val sum = add(2, 3)
    val gg = sum(2, 3)
    println(gg)
    "dewansh".myfunc("hh")
    val p1 = Patient("Bhavesh")
    val p2 = Patient("Bhavesh")

    print(p1 == p2)//true
    print(p1.equals(p2))//true
    print(p1 === p2)// false
    print(p1 === p2)// false

}

//fun add( a:Int, b:Int) :(Int,Int)->Int{
//    return {a,b -> a+b}
//}
//
//fun main() {
//
//}
