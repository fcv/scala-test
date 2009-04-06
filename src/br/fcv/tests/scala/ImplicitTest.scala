package br.fcv.tests.scala

object ImplicitTest extends Application {

  abstract class SemiGroup[A] {
    def add(x: A, y: A): A
  }
  
  abstract class Monoid[A] extends SemiGroup[A] {
	def unit: A
  }
  
  implicit object StringMonoid extends Monoid[String] {
	def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }
  
  implicit object IntMonoid extends Monoid[int] {
	def add(x: Int, y: Int): Int = x + y
	def unit: Int = 0
  }
  
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))

  println(sum(List(1, 2, 3, 4))) // -- prints '10'
  println(sum(List("a", "b", "c"))) // -- print 'abc'
  println(sum(List[Int]())) //-- prints '0'
  
  val myMonoid = new Monoid[Int] {
                                  def unit = 1
                                  def add(x:Int, y:Int) = x * y
                                }; 
  
  println( sum(List(1, 2, 3, 4))(myMonoid) ) // -- expliciting the monoid -- prints '24' 

}
