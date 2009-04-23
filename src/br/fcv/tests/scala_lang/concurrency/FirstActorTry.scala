package br.fcv.tests.scala_lang.concurrency

import actors.Actor
import Actor._

object FirstActorTry {
  
  case class TextMessage(msg: String)
  case class EndOfTransmission()
  
  def main(args: Array[String]) {
    def ct = Thread.currentThread.getName
    
    val myActor = actor {
      var active = true;
      
      while (active) {
        receive {
          case TextMessage(msg) => println("[" + ct + "] " + msg )
          case EndOfTransmission => active = false
          case x => println("[" + ct + "] unknow message type: " + x)
        }
      }
    }
    println("[" + ct + "] starting messages")
    myActor ! TextMessage("my message #1")
    myActor ! TextMessage("my message #2")
    myActor ! "another message"
    println("[" + ct + "] finished with messages")
    myActor ! EndOfTransmission
    
    // prints: 
	//  [main] starting messages
	//  [main] finished with messages
	//  [Thread-2] my message #1
	//  [Thread-2] my message #2
	//  [Thread-2] unknow message type: another message
  }

}
