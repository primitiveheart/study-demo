package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 12:33 上午
 * @Created By guanbao.zhou
 * @author xmly
 *         在scala中，第一次无论是继承还是实现特质，都使用extends关键字，并且extends只能使用一次
 */
class Pig extends Flyable with Fightable {
  // 重写没有实现的方法，可以加override，也可以不加
  override def fly(): Unit = {
    println("飞")
  }
  // 重写哪些已经有实现的方法，需要加override
  override def fight(): Unit = {
    println("使用其它方式打架")
  }
}
