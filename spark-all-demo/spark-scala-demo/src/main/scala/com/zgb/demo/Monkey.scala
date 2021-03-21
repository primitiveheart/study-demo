package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 12:29 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
class Monkey extends Animal with Flyable {


  override def run(): Unit = {
    println("走")
  }

  override def fly(): Unit = {
    println("飞飞")
  }
}
