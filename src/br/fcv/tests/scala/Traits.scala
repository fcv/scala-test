package br.fcv.tests.scala

object Traits extends Application {
  
  trait Trait1 {
    def name = "Trait1"
  }
  
  trait Trait2 {
    def name = "Trait2"
  }
  
  class SuperClass {
    def name = "SuperClass"
  }
  
  class SubClass extends SuperClass {
    override def name = "SubClass"
  }
  
  var is = 1 :: 2 :: 3 :: Nil

}
