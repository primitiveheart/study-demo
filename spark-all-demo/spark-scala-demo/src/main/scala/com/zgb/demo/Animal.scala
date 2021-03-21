package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 12:27 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
abstract class Animal {

  // 抽象的方法
  def run() : Unit

  def breath() = {
    println("氧气")
  }
}
