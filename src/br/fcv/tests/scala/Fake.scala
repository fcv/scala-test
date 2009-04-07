package br.fcv.tests.scala

import java.io

object Fake extends Application {
  
  private def filesHere = new io.File(".").listFiles
    
  private def get = {
    for (file <- filesHere; if file.isDirectory) 
      yield file
  }
  
  get foreach { a => println(a.getCanonicalPath()) } 
    // {  println(_) }
    
  import java.lang.Integer;
  
  val one1 = new Integer(1);
  val one2 = new Integer(1);
  
  println("==: " + (one1 == one2 )) //-- prints true
  println("equals: " + (one1 equals one2) ) //-- prints true
  println("eq: " + (one1 eq one2) ) //-- false 
  
  
  import collection.mutable.ArrayStack;
  var stack = new ArrayStack[Int];
  stack ++= List(1,2,3,4,5)
  println;
  println( stack );
  stack reduceWith {(a, b) => a+b} 
  
  println( stack );
  
}

