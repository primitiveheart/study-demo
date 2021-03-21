package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:55 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         上界和下届使用泛型是为了让程序更加灵活，并且可以约束类型的界限
 */
class Pair[T <: Comparable[T]] {
  def bigger(first: T, second: T): T = {
    if (first.compareTo(second) > 0) first else second
  }
}

object Pair {
  def main(args: Array[String]): Unit = {
    val pair = new Pair[Integer]
    val r = pair.bigger(5, 10)
    println(r)
    // 输出结果：10

    val pair2 = new Pair[String]
    val r2 = pair2.bigger("jerry", "tom")
    println(r2)
    // 输出结果：tom

    // 装的是scala的Int
    // Int的没有继承Comparable
    // 报错
//    val pair3 = new Pair[Int]
//    val r3 = pair3.bigger(5,10)
//    println(r3)
  }
}
