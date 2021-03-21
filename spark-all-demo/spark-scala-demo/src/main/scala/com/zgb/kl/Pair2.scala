package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 11:21 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         视图界定，可以实现隐式转换
 */
class Pair2[T <% Comparable[T]] {
  def bigger(first: T, second: T): T = {
    if (first.compareTo(second) > 0) first else second
  }
}

object Pair2 {
  def main(args: Array[String]): Unit = {
    // 转的是scala的Int
    // 视图界定:可以隐式转换，将Int转成Integer
    // Implicit def int2Integer(x: Int) = java.lang.Integer.valueOf(x)
    val pair = new Pair2[Int]
    val r = pair.bigger(5, 3)
    println(r)
  }
}
