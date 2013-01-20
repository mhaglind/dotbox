package com.haglind.dotbox

import akka.actor._
import com.haglind.dotbox.common._

class TickEmitter (system:ActorSystem) extends Actor with ActorLogging {

  var running:Boolean = false
  var tickCounter:Long = 0
  
  def receive = {
    case m:Start => {
      running = true
      run
    }
    case m:Stop => {
      running = false
    }
    case m:AddDot => {
      addDot(m)
    }
  }
  
  def run = {
    while (running) {
    	dot!new Tick(tickCounter)
    	tickCounter += 1
    	Thread.sleep(500)
    }
  }
  
  var dot:ActorRef = null
  
  def addDot(ad:AddDot) = {
	 dot = system.actorOf((Props[Dot]), "dotActor")
  }
}