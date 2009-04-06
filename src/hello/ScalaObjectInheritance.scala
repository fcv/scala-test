package hello

object ScalaObjectInheritance extends Application {
  
  class Tunico(value: String) {
    def foo = println("my value = " + value)
  }
  
  object Parent {
    def myMethod = println("I'm a parent");
  }
  
  object Child extends Tunico("caricota") {  
    override def foo = println("my (overrwritten) value = caricota")
  }
  
  var c:Tunico = Child;
  Parent.myMethod
  
  
  c.foo
  c = new Tunico("caricota");
  c.foo ;

  
}
