package br.fcv.tests.scala_lang

import java.util.{List, ArrayList, Collections, Arrays, Comparator}


object ImplicitComparatorConverter extends Application {

  class Holder(val i:Int) {
    override def toString = i.toString
  }
  object Holder {
    def apply(i:Int) = new Holder(i)
  }
  
  val list:List[Holder] = new ArrayList[Holder]()
  list.addAll( Arrays.asList(Holder(8), Holder(1), Holder(3), Holder(2), Holder(7)) )
  
  /**
   * Converts a function of type (T,T) => Boolean into Comparator[T] 
   */
  implicit def closure2comparator[T](func: (T, T) => Int):Comparator[T] = new Comparator[T]() {
    def compare(a:T, b:T):Int = {
      func(a,b)
    }
  }
  
  val comp:Comparator[Holder] = (x:Holder, y:Holder) => { y.i - x.i }
  
  Collections.sort(list, comp) //-- using pre defined instance
  Collections.sort(list, (x:Holder, y:Holder) => { y.hashCode - x.hashCode }) //-- "inline" declaration
  
  val objComp: Comparator[Object] = null
  // Collections.sort(ints, objComp) <-- compiler error
  // 
  // -- it seems scala compiler (2.7.3 version so far) does not infer the generic types correctly in this case ...
  // at least not as java compiler
  // 
  // "type mismatch; found : java.util.List[br.fcv.tests.scala_lang.ImplicityComparatorConverter.Holder] required: 
  // java.util.List[java.lang.Object]"

  Collections.sort[Holder](list, objComp) // compiles with no error
}
