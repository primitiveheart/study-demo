package com.zgb

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 4:19 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         元组：元素的组合，有序的
 *         特点：长度和内容都可以改变，取元素是tp._1,角标是从1开始
 */
object TupleDemo {
  def m(x: Int, y: Double) = {
    val x1 = x * 10
    val y1 = y * 100
    val w1 = "hello"
    (x1, y1, w1)
  }
  def main(args: Array[String]): Unit = {
    val tp: (Int, Double, String) = m(1,2.0)
    val s1 = tp._3;
    val d: Double = tp._2;
    println(s1)
  }
}
