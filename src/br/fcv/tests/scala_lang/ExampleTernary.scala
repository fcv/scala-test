package br.fcv.tests.scala_lang

object ExampleTernary extends Application {
  
  object TernaryOp {
    implicit def fakeTernary[A](a:(A,A)) = new {
      def ?:(p:Boolean)=if(p) a._1 else a._2
    }  
    //Before adding the Tuplicator class the compiler got very confused
    // between anonymous classes
    
    // -- This will, in fact, add ~: operator at all  classes ...
    // -- that is not something i would like

    class Tuplicator[A](a:A){
      def ~:(b:A) = (b,a)
    }
    implicit def tuplicate[A](a:A) = new Tuplicator(a)
  }

  {
	// -- import is visible only inside this context bounds  
    import TernaryOp._
	  
	var a = {
	  "teste"
	}
	  
	var b = {
	  "tunico"
	}
	  
	println( "before ternary call" )
	println( (1>3) ?: a ~: b )
  }
  
  //-- it is not possible to call '?' operation over Boolean here!!
  
}
