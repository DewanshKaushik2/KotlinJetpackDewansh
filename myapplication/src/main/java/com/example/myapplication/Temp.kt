//
class Temp {

}

fun higherOrder() : (Int,Int) -> Int {
  return {a:Int, b:Int -> a+b}
}

fun String.myextension() : String{
    return "my name is  $this"
}

data class Patient(var className: String)

fun main() {
   var a= higherOrder()
    println("mere wala :-> " + a(1,2))
    println("ddddd ".myextension())
    val p1 = Patient("Bhavesh")
    val p2 = Patient("Bhavesh")

    println(p1 == p2)//true
    println(p1.equals(p2))//true
    println(p1 === p2)// false
    println(p1 === p2)// false

}

//fun add( a:Int, b:Int) :(Int,Int)->Int{
//    return {a,b -> a+b}
//}
//
//fun main() {
//
//}
