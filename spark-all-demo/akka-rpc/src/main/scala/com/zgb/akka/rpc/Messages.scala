package com.zgb.akka.rpc

// Worker发送给Master的注册信息，case class默认实现了序列化接口
case class RegisterWorker(id: String, memory: Int, cores: Int)

// Master发送给worker注册成功的信息
case object RegisteredWorker

// worker发送给Master的心跳信息
case class Heartbeat(workerId: String)

// worker自己给自己发送的信息
case object SendHeartbeat

// master发送给自己的信息，用于就检查超时的worker
case object CheckTimeOutWorker