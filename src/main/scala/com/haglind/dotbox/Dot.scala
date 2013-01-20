package com.haglind.dotbox

import akka.actor._
import akka.actor.SupervisorStrategy.Restart
import akka.actor.SupervisorStrategy.Stop
import com.haglind.dotbox.common.Tick

class Dot (
  ) extends Actor with ActorLogging {
  
  def receive = {
    case tick:Tick => {
      log.info("Dot.tick:" + tick.tickNumber)
    }
    
  }
  
}