package com.zgb

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/10 8:30 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
object MethodDemo {


  def add(x: Int, y: Double): Double = {
    x + y
  }

  def add2(x: Int, y: Double) = {
    x + y
  }

  def add3(x: Int, y: Double) {
    x + y
  }

  def add4(x: Int, y: Double): Unit = {
    x + y
  }

  def add5(x: Int, y: Double): Unit = {
    x + y
    (); // unit 相当于java中void
  }

  def noArg: Unit = {
    println("无参数方法")
  }

  // * 表示可变参数
  def multily(x: Int, y: Int*) = {
    x + y.sum
  }

  def main(args: Array[String]): Unit = {
    println(add(1, 2));
    println(add2(1, 2));
    println(add3(1, 2));
    println(add4(1, 2));
    println(add5(1, 2));
    println(noArg)
    println(multily(1, 2, 3))
    // 输出结果：
    /**
     * 3.0
     * 3.0
     * ()
     * ()
     * ()
     * 无参数方法
     * ()
     * 6
     */
  }
}
