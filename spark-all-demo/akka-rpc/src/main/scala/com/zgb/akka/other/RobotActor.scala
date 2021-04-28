package com.zgb.akka.other

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

class RobotActor extends Actor {
  val log = Logging(context.system, this)
  def receive: Receive = { //机器人接受指令
    case t: TurnOnLight => log.info(s"${t.message} after ${t.time} hour")
    case b: BoilWater => log.info(s"${b.message} after ${b.time} hour")
    case _ => log.info("I can not handle this message")
  }
}

object RobotActor {
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem("robot-system")
    val robotActor = actorSystem.actorOf(Props(new RobotActor()), "robotActor") //创建一个机器人
    println(s"the ActorSystem logLevel is ${actorSystem.settings.LogLevel}")
    robotActor ! TurnOnLight(1) //给机器人发送一个开灯命令
    robotActor ! BoilWater(2) //给机器人发送一个烧水命令
    robotActor ! "who are you" //给机器人发送一个任意命令
    actorSystem terminate ()
  }
}