package br.fcv.tests.scala_lang

object PatternMatching extends Application {
  
  abstract class Expr
  case class Var(name: String) extends Expr
  case class Num(num: Double) extends Expr
  case class UnOp(op: String, exp: Expr) extends Expr
  case class BinOp(op: String, left: Expr, right: Expr) extends Expr
  
  def simplifyTop(expr: Expr): Expr = expr match {
	case UnOp("", UnOp("",e)) => e // Double negation
	case BinOp("+", e, Num(0)) => e // Adding zero
	case BinOp("*", e, Num(1)) => e // Multiplying by one
	case _ => expr
  }
  
  def foundNums(expr: Expr) = {
    import collection.mutable.Queue
    var nums = new Queue[Double]();
    
    def innerFound(expr: Expr):Unit = expr match {
      case Num(x) => nums += x
      case UnOp(_, exp) => innerFound(exp)
      case BinOp(_, left, right) => { innerFound(left); innerFound(right) }
      case _ => 
    }   
    
    innerFound(expr)
    
    nums
  }
  
  println ( foundNums( BinOp("+", Num(2), Num(1)) ) )

}
