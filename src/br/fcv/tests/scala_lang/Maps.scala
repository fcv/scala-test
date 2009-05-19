package br.fcv.tests.scala_lang

import scala.collection.mutable.HashMap 

object Maps extends Application {
  
  val myMap = new HashMap[Int, String]() {
	  override def default(a: Int) = null
  }
                           
  myMap ++= List(1 -> "one", 2 -> "two", 3 -> "three")
  
  println(myMap(1))
  println(myMap(2))
  // println(m(5)) //-- throws NoSuchElementException unless i override 'default(K)' method
}
