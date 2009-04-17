package br.fcv.tests.scala.extractors

/**
 * Example of Extractors with regular expression usage 
 * taken from Programming in Scala book
 */
object RegExp extends Application {

  import String.format
  
  val Decimal = """(-)?(\d+)(\.\d*)?""".r
  
  val input = "bla bla 1% bla bla 6.3 bla lba -20.1 d"
  
  for (x <- Decimal findAllIn input) {
    println(x)
  }
  //-- prints:
  // 1, 6.3 and -20.1
  
  // We can also use RegExp in assignments... just like  "val (x,y) = (1, 2)" expression
  // So:
  for (Decimal(s, i, d) <- Decimal findAllIn "um valor 1.2 em 1 ou -1") {
    println( format("sign: %s, integer: %s, decimal: %s", s, i, d) )
  }
  //-- prints:
  // sign: null, integer: 1, decimal: .2
  // sign: null, integer: 1, decimal: null
  // sign: -, integer: 1, decimal: null
  
}
