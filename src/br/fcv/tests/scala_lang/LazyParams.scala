package br.fcv.tests.scala_lang

object LazyParams extends Application {
  
  class Obj
  
  // from: http://scala.sygneca.com/faqs/language#what-s-the-difference-between-a-lazy-argument-a-no-arg-function-argument-and-a-lazy-value
  def callByValue(param: Obj) = {
    val a = param;
    val b = param;
    println("a eq b: " + (a eq b))
  } 
  
  def callByName(param: => Obj) {
    val a = param;
    val b = param;
    println("a eq b: " + (a eq b))
  }

  def callByNameLazilly(param: => Obj) {
    lazy val y = param;  
    val a = y;
    val b = y;
    println("a eq b: " + (a eq b))
  }
  
  private def factory = {  
    println ("creating new Obj instance")
    new Obj
  }

  val obj = new Obj
  println(" -> callByValue(obj)")
  callByValue(obj)
  println(" -> callByName(obj)")
  callByName(obj)
  println(" -> callByName(factory)")
  callByName(factory)
  println(" -> callByNameLazilly(factory)")
  callByNameLazilly(factory)
  
  // prints:
  //   -> callByValue(obj)
  //  a eq b: true
  //   -> callByName(obj)
  //  a eq b: true
  //   -> callByName(factory)
  //  creating new Obj instance
  //  creating new Obj instance
  //  a eq b: false
  //   -> callByNameLazilly(factory)
  //  creating new Obj instance
  //  a eq b: true
  
}
