package br.fcv.tests.scala

import java.io

object Fake extends Application {
  
  private def filesHere = new io.File(".").listFiles
  
  private def get = {
    for (file <- filesHere; if file.isDirectory) 
      yield file
  }
  
  get foreach { println(_) }
    

}
