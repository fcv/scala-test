package br.fcv.tests.scala

import collection.mutable.HashMap 

object Maps extends Application {
  
  val m = HashMap[Int, String]()  
//  {
//    override def default(a: Int) = null
//  }
                           
  m ++= List(1 -> "one", 2 -> "two", 3 -> "three")
  
  println(m(1))
  println(m(2))
  println(m(5)) //-- throws NoSuchElementException unless i override 'default(K)' method
}
