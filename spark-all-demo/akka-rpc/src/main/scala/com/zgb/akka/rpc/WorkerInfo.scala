package com.zgb.akka.rpc

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:55 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
class WorkerInfo(val id: String, var memory: Int, var cores: Int) {
  var lastUpdateTime: Long = _

  override def toString: String = s"WorkerInfo($id, $memory, $cores)"
}
