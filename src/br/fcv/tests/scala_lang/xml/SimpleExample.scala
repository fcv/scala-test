package br.fcv.tests.scala_lang.xml

import _root_.scala.xml.NodeSeq.Empty

object FirstTry extends Application {
  
  val n = 
<my-node>
  <a prop="my-prop"></a>
  <b>
    <b-a>content of ba</b-a>
  </b> 
</my-node>
  
  
  val n1 = n \ "b-a"
  
  println(n1 == Empty) //-- prints "true"
  println(n1) //-- prints nothing
  println(n \ "a" \ "@prop") //-- prints "my-prop" 
  println(n \\ "b-a") //-- prints "<b-a>content of ba</b-a>"
  println(n \ "c" \ "b-a") //-- prints nothing but gives no exceptions ... sounds good
  println(n \ "b" \ "b-a") //-- prints "<b-a>content of ba</b-a>"
 
}