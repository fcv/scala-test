package hello

object MyFor extends Application {

  def repeat(count: Int)(body: => Unit): Unit  = {
    if (count > 0) {
      body;
      repeat(count - 1) (body);
    }
  }

  
  repeat(2) {
    println("teste")
  }
}
