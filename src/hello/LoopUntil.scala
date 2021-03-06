package hello

object LoopUntil extends Application {
  def loop(body: => Unit): LoopUnlessCond =
    new LoopUnlessCond(body)
  protected class LoopUnlessCond(body: => Unit) {
    def unless(cond: => Boolean) {
      body
      if (!cond) unless(cond)
    }
  }
  var i = 1
  loop {
    println("i = " + i)
    i -= 1
  } unless (i == 0)
}
