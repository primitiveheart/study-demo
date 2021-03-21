package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 11:26 下午
 * @Created By guanbao.zhou
 * @author xmly
 * 1.在scala中有两个特质Ordered、Ordering
 * 2.这两个特质专门是用来的比较
 * 3.Ordered 实现了Comparable接口，Ordered对Comparable接口进行可扩展
 * 4.Ordering 实现了Comparator接口，Ordering对Comparator接口进行了扩展
 * 目的就是为了进行比较时更加方便
 * 视图界定就是为了实现隐式转换的，视图界定需要传入一个转换方法或函数，优先使用函数
 */
class Pair3[T <% Ordered[T]] {
  def bigger(first: T, second: T): T = {
    if (first >= second) first else second
  }
}

object Pair3 {
  def main(args: Array[String]): Unit = {
    // 背后有一股神奇的力量[隐式转换]
    // Int 转成了 Ordering[int]
    // Ordered中有一个隐式转换方法，可以将Ordering[T]转成Ordered[T]
    // Ordering[Int]转成Ordered[Int]
    // 将Int转成了Ordered[Int]
    // implicit修饰的方法或函数
    val p = new Pair3[Int]

    val r = p.bigger(5, 8)
    println(r)

    val p2 =new Pair3[Boy]
    val r2 = p2.bigger(new Boy("laoz", 999), new Boy("laozhou", 9999))
    println(r2)

    import MyPredef.boy2OrderedBoy2
    val p3 = new Pair3[Boy2]
    val r3 = p3.bigger(new Boy2("laoz", 999), new Boy2("laozhou", 9999))
    println(r3)

  }
}
