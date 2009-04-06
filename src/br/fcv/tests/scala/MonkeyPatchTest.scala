package br.fcv.tests.scala

object MonkeyPatchTest extends Application {
  
  class IsBlankEnricher(that:String) {
    def isBlank:Boolean = that.trim().length() == 0;
  }
    
  implicit def elvisOperator[T](alt: T) = new {
    def ?:[A >: T](pred: A) = if (pred == null) alt else pred
  }
  
  implicit def addIsBlankToStr(str: String) = new IsBlankEnricher(str)

  implicit def addForEachForCharacter[T >: CharSequence](that: T) = new {
    def forEachChar(body: Char => Unit) = {}
  }
  
  var blank = "   ";
  var notBlank = "  da ";
  
  var x = 1;
  
  println( x ?: 2)
  
  println(blank isBlank)
  println(notBlank isBlank)
  
  notBlank forEachChar { x => print( x + ", ") } 

}