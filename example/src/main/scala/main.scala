import example.Lists.*

object main:
  @main def run(): Unit =
    var myList = List(1,3,2)
    println(max(myList))
    println(max(List()))
    println(sum(myList))
    println(sum(List()))
