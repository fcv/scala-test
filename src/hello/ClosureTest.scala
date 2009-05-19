package hello

object ClosureTest extends Application {
  
  def surround (b: String) (a: Int) (body:  => Boolean ) = {
    println("before")
    if (body) {
      println("ok")
    }
    println("after")
  };
  
  def surroundIt(body: () => Unit ): () => Unit = 
    () => {
      println ("before");
      body apply;
      println ("after");
    }
  

  var a = 1;
  var b = 2;
  surround ("1") (1) {
    println("middle");    
    false;
  }
  
  def decorate (fn: () => Int): () => Int  = {
    () => {
      println( "inside decorated method" )
      fn()
    }
  }
  
  var i = 2;
  var fn = () => {
    i += 1;
    i;
  }
  
  fn = decorate(fn)
  i = 3;
  println( fn() );
  
  
  val myFunc = surroundIt { () => println("undergone function" )}
  
  myFunc()
  
}
