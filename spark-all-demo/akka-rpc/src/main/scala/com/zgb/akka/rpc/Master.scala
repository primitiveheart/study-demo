package com.zgb.akka.rpc

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable
import scala.concurrent.duration._

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:14 上午
 * @Created By guanbao.zhou
 * @author xmly
 *         以后要实现是Actor编程模型进行通信，与Akka关联
 */
class Master extends Actor {

  val id2Worker = new mutable.HashMap[String, WorkerInfo]()


  // 在preStart中启动定时器，定时检查超时的worker，然后剔除
  override def preStart(): Unit = {
    import context.dispatcher

    context.system.scheduler.schedule(0 millisecond, 10000 millisecond, self, CheckTimeOutWorker)
  }

  override def receive: Receive = {
    case "hello" => {
      println("receive a hello msg")
    }

    // worker 发送给master的消息
    case "register" => {
      println("receive a register msg from worker")
    }
    // worker发送给master的消息
    case RegisterWorker(id, memory, worker) => {
      // 1.将数据封装起来，保存到内存中
      val workerInfo = new WorkerInfo(id, memory, worker)

      // 2.保存到内存
      id2Worker(id) = workerInfo
      // 3.向worker反馈一个注册成功的消息
      // Master向worker发送消息
      sender() ! RegisteredWorker
    }

    // worker发送给Master的心跳信息[周期性的]
    case Heartbeat(workerId) => {
      if (id2Worker.contains(workerId)) {
        // 根据ID取出workerInfo
        val workerInfo = id2Worker(workerId)
        // 获取当前时间
        val currentTime = System.currentTimeMillis()
        // 更新最近一次心跳时间
        workerInfo.lastUpdateTime = currentTime
      }
    }

    case CheckTimeOutWorker => {
      // 取出超时的worker
      val currentTime = System.currentTimeMillis()
      // 遍历超时的worker
      val workers = id2Worker.values;
      val deadWorkers = workers.filter(w => currentTime - w.lastUpdateTime > 10000)

      deadWorkers.foreach(w => {
        // 移除超时的worker
        id2Worker -= w.id
      })

      println("current alive worker is " + id2Worker.size)
    }
  }
}

object Master {
  def main(args: Array[String]): Unit = {
    val host = "localhost"
    val port = 8888
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
         """.stripMargin;
    // 1.创建一个ActorSystem【单例，在scala中就是一个object】
    val conf = ConfigFactory.parseString(configStr);
    val actorSystem = ActorSystem("MASTER_ACTOR_SYSTEM", conf)

    // 2.通过ActorSystem而创建Actor
    // 通过发射创建指定类型的Actor类型
    val masterActor = actorSystem.actorOf(Props[Master], "MASTER_ACTOR");

    // 3.向Actor发送消息
    // ！表示发送异步消息
    masterActor.!("hello")
  }
}
