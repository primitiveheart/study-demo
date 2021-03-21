package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 12:24 上午
 * @Created By guanbao.zhou
 * @author xmly
 *         通常在类的伴生对对象中定义apply()方法，当遇到类名(参数 1， 参数2。。)时apply方法被调用
 */
object ApplyDemo {
  def apply() = {
    println(999)
  }

  def main(args: Array[String]): Unit = {
    // 静态对象名后面跟(),就是调用对应的apply方法
    ApplyDemo()
    ApplyDemo.apply()
  }
}
