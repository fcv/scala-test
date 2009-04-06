package br.fcv.tests.scala

object BooleanMonkeyPatching extends Application {
  
  class FistTernary[R](cond: Boolean, body: => R) {
    def  | (secondBody: => R):R = {
      if (cond) body else secondBody
    }
  } 
    
  implicit def addTernaryOperator(that: Boolean) = new {
    def ?[R >: AnyRef](trueSt: => R):FistTernary[R] = {
      return new FistTernary(that, trueSt)
    }
  }
  
  var x = true;
  
  var yes = {
    println("inside yes")
    "" + x + "!"
  }
  
  var no = {
    println("inside no")
    "" + x + "!"
  }
  
  println("before ternary operator")
  
  var str = x ? yes | no 
  
  println ("result of ternary operator: " + str)

}
