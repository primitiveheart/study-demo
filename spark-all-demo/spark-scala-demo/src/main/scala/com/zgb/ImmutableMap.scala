package com.zgb

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 3:50 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         不可变的Map，长度和内容都不可变，跟使用var还是val修饰没关系
 */
object ImmutableMap {
  def main(args: Array[String]): Unit = {
    // 定义一个不可变的map
    val m1 = Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4, "e" -> 5, "f" -> 6)
    // 从map中取值
    val v2 = m1.getOrElse("w", -1)
    println(v2)
  }
}
