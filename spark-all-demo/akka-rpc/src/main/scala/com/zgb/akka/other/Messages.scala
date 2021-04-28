package com.zgb.akka.other

import akka.actor.ActorPath

trait Action{
val message: String
val time: Int
}

case class TurnOnLight(time: Int) extends Action {   // 开灯消息
  val message = "Turn on the living room light"
}

case class BoilWater(time: Int) extends Action {   // 烧水消息
  val message = "Burn a pot of water"
}


trait Message {
  val content: String
}
case class Business(content: String) extends Message {}
case class Meeting(content: String) extends Message {}
case class Confirm(content: String, actorPath: ActorPath) extends Message {}
case class DoAction(content: String) extends Message {}
case class Done(content: String) extends Message {}