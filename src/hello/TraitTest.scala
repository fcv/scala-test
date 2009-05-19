package hello

object TraitTest extends Application {
  
  abstract class Bladu[T] {
    
  }
  
  class Test extends Bladu with AnotherBehavior with Behavior {    
  } 
  
  trait Behavior {
    def doSomething1 = {};
  }
  
  trait AnotherBehavior {
    def doSomething = {};
  }
  
  var a = new Test();

  
}
