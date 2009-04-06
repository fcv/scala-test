package hello

object ScalaOpOverloading extends Application  {
  class MyInt(val value: Int) {
    def + (that: MyInt) = {
      println("overloaded +")
      new MyInt( value + that.value )
    }
    
    def * (that: MyInt) =  {
      println("overloaded *")
      new MyInt( value * that.value )
    }
    
    def ++ = new MyInt(value + 2)
    
    override def toString = String.valueOf(value)
  }
  
  val two = new MyInt(2);
  val three = new MyInt(3);
  val four = new MyInt(4);
  
  println ( two + three * four );
  println ("two ++ = " + (two ++) )
}
