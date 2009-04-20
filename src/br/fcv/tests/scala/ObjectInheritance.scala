package br.fcv.tests.scala

object ObjectInheritance extends Application {

  class Skeleton {
    protected var i = 1;
    
    def apply() = i
    def update(ni: Int) = i = ni
  }
  
  object Parent extends Skeleton
  
  println(Parent())
  Parent() = 2
  println(Parent())
  
  // Parent.i 
  // --variable i cannot be accessed in object br.fcv.tests.scala.ObjectInheritance.Parent 
  
  class P 
  
  object Child extends Skeleton {
    override def update(ni: Int) = i = ni * 2
  }
  
  println(Child())
  Child() = 2
  println(Child())
}
