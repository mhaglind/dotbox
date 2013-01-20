package com.haglind.dotbox

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import com.haglind.dotbox.common._

object App extends App {
  
  val config = ConfigFactory.load()
  val system = ActorSystem("DotBoxSystem", config)
  
  val tickEmitter = system.actorOf(Props(new TickEmitter(system)), "tickEmitterActor")
  
  tickEmitter!new AddDot(1,1)
  tickEmitter!new Start
}