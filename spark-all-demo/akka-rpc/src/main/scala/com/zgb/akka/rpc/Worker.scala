package com.zgb.akka.rpc

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._
import scala.language.postfixOps

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:14 上午
 * @Created By guanbao.zhou
 * @author xmly
 *         worker Actor在构造函数方法执行之后，receive方法执行之前，向master建立连接
 */
class Worker extends Actor {

  val WORKER_ID = UUID.randomUUID().toString

  var masterRef: ActorSelection = _

  /**
   * 在构造函数方法执行之后，receive方法执行之前，执行一次preStart
   */
  override def preStart(): Unit = {
    // 1.worker向master建立网络连接
    masterRef = context.actorSelection("akka.tcp://MASTER_ACTOR_SYSTEM@localhost:8888/user/MASTER_ACTOR")
    // 2.Worker向master发送注册的信息
    //    masterRef ! "register";
    masterRef ! RegisterWorker(WORKER_ID, 4096, 8)

  }

  override def receive: Receive = {
    case "hi" => {
      println("hi-----")
    }
    //  Master反馈给worker的信息
    case RegisteredWorker => {
      // 导入隐式转换
      import context.dispatcher

      // 启动一个定时器，定期向Master发送心跳，使用Akka框架封装的定时器
      // 定期给自己发送信息，然后再给Master发送心跳
      context.system.scheduler.schedule(0 millisecond, 5000 millisecond, self, SendHeartbeat)
    }

    case SendHeartbeat => {
      // 可以进行逻辑的判断
      //  向master发送心跳信息
      masterRef ! Heartbeat(WORKER_ID)
    }

  }
}

object Worker {
  def main(args: Array[String]): Unit = {
    val host = "localhost"
    val port = 9999
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
         """.stripMargin;
    // 1.创建一个ActorSystem【单例，在scala中就是一个object】
    val conf = ConfigFactory.parseString(configStr);
    val actorSystem = ActorSystem("WORKER_ACTOR_SYSTEM", conf)

    // 2.通过ActorSystem而创建Actor
    // 通过发射创建指定类型的Actor类型
    val workerActor = actorSystem.actorOf(Props[Worker], "WORKER_ACTOR");

    // 3.向Actor发送消息
    // ！表示发送异步消息
    workerActor.!("hello")
  }
}
