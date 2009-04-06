package br.fcv.tests.scala

object Enums extends Application {
  
  object Suit extends Enumeration {
    type Suit = Value

    val SPADES = Value("SPADES") 
    val HEARTS = Value("HEARTS") 
    val DIAMONDS = Value("DIAMONDS") 
    val CLUBS = Value("CLUBS")
    
    def isRed(that: Suit) = that == HEARTS || that == DIAMONDS
  }
 
  
  Suit filter Suit.isRed foreach ( x => print( x + " ") ) 
  
  println;
  
  println(Suit valueOf "SPADES"  get )

} 