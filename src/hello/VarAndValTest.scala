package hello

object VarAndValTest  {
  
  def main(args: Array[String]) {
    var count = 1;
    val value = 2;
    count = 2;
    // value = 1 ... not valid assignment
    
    
    val foo = new Foo();
    // foo.getClass.getMethods.foreach( println )
    
   
    
    val test = () => if (count > 1) "is greater " + count else "is lower " + count 
    
    var a = test;
    println( a )
    
    println(test getClass)
  }  
  
}