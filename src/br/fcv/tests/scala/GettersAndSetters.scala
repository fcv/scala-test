package br.fcv.tests.scala

import java.util.Date

object GettersAndSetters extends Application {

  class SimpleBean(private var n: String) {
    def name = {
      println("[log] getting name") 
      n
    }
    
    // note: 
    // no space between "name_" and "=" is allowed since 'name_=' is the very method's name
    // neither "name_(xxx: String) = {..." 
    def name_= (name: String) {
      println("[log] setting new name")
      n = name
    }
  }
  
  var bean = new SimpleBean("tunico")
  println(bean.name)
  bean.name = "genesio"
  println(bean.name)
  // prints:
  //   [log] getting name
  //   tunico
  //   [log] setting new name
  //   [log] getting name
  //   genesio
  
    
  // ----------------------------  
  // no need of explicity local variable... 
  // from Programming in Scala book
  class Thermometer {
    // obs: "= _" means assign default value...
    // only "var celsius: Float" would mean abstract var declaration
    var celsius: Float = _  
    def fahrenheit = celsius * 9 / 5 + 32
    def fahrenheit_= (f: Float) {
      celsius = (f - 32) * 5 / 9
    }
    override def toString = fahrenheit +"F/"+ celsius +"C"
  }

  var thermometer = new Thermometer
  println(thermometer) // prints: 32.0F/0.0C
  thermometer.celsius = 100 
  println(thermometer) // prints: 212.0F/100.0C
  thermometer.fahrenheit = -40
  println(thermometer) // prints: -40.0F/-40.0C
  
}
