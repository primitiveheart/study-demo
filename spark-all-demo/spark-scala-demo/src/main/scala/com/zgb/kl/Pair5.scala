package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/21 2:36 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         使用柯里化结合隐式参数，实现隐式转换
 */
class Pair5[T] {
  // 柯里化结合隐式参数，实现隐式转换，传入一个隐式转换函数
  // 这种方式和视图界定的效果一样
  def choose(first: T, second: T)(implicit ord: T => Ordered[T]): T = {
    if (first >= second) first else second
  }

  // 使用柯里化结合隐式参数，需要传入一个隐式的Object
  // 这种方式类似可以实现上下文界定
  def select(first: T, second: T)(implicit ord: Ordering[T]): T = {
    if (ord.gt(first, second)) first else second
  }
}

object Pair5 {
  def main(args: Array[String]): Unit = {
    val p = new Pair5[Boy]
    val r = p.choose(new Boy("laoz", 999), new Boy("laozhou", 9999))
    println(r)

    import MyPredef.OrderingMan
    val p2 = new Pair5[Man]
    val r2 = p2.select(new Man("laoz", 999), new Man("laozhou", 9999))
    println(r2)
  }
}