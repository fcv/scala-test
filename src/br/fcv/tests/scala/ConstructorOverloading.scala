package br.fcv.tests.scala

object ConstructorOverloading extends Application {

  class MyClass(var name: String, var age: Int) {
    def this(name: String) = this(name, 18)
    
    override def equals(other: Any) = {
      //-- println("equals called")
      var eq = false
      
      if (other.isInstanceOf[MyClass]) {
        val myClass = other.asInstanceOf[MyClass]
        eq = name == myClass.name && age == myClass.age
      }
      
      eq
    }
    
    override def toString = {
      "{name: " + name + ", age: " + age + "}"
    }
  }
  
  val m1 = new MyClass("Tunico", 21);
  val m2 = new MyClass("Genesio")
  val m3 = new MyClass("Tunico", 21);
  
  
  println("m1 == m3 -> " + (m1 == m3)) //-- prints true
  println("m1 equals m3 -> " + (m1 equals m3)) //-- prints true
  println("m1 eq m3 -> " + (m1 eq m3)) //-- prints false
  println //-- new line
  println(m2) //-- prints {name: Genesio, age: 18}

}
