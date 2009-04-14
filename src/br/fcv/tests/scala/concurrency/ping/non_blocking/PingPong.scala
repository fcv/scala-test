package br.fcv.tests.scala.concurrency.ping.non_blocking

import actors.Actor
import Actor._

object PingPong extends Application {
  
  case object Ping
  case object Pong
  case object Stop
  
  private def ct = "[" + Thread.currentThread.getName + "]"
  
  class Ping(count: Int, pong: Actor) extends Actor {
    def act() {
      var pingsLeft = count - 1
      pong ! Ping
      loop {
        react {
          case Pong =>
            if (pingsLeft % 1000 == 0)
              Console.println(ct + " Ping: pong")
            if (pingsLeft > 0) {
              pong ! Ping
              pingsLeft -= 1
            } else {
              Console.println(ct + " Ping: stop")
              pong ! Stop
              exit()
          }
        }
      }
    }
  }

  class Pong extends Actor {
    def act() {
      var pongCount = 0
      loop {
        react {
          case Ping =>
            if (pongCount % 1000 == 0)
              Console.println(ct + " Pong: ping "+pongCount)
            sender ! Pong
            pongCount = pongCount + 1
          case Stop =>
            Console.println(ct + " Pong: stop")
            exit()
        }
      }
    }
  }

  val pong = new Pong
  val ping = new Ping(5000, pong)

  ping.start
  pong.start
  
  // prints: 
  //  [Thread-1] Pong: ping 0
  //  [Thread-3] Ping: pong
  //  [Thread-3] Pong: ping 1000
  //  [Thread-3] Ping: pong
  //  [Thread-3] Pong: ping 2000
  //  [Thread-4] Ping: pong
  //  [Thread-4] Pong: ping 3000
  //  [Thread-4] Ping: pong
  //  [Thread-4] Pong: ping 4000
  //  [Thread-3] Ping: pong
  //  [Thread-3] Ping: stop
  //  [Thread-3] Pong: stop
  
}
