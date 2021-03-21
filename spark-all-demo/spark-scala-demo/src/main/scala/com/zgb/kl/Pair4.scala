package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/21 2:25 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         1上下文界定，也是为了实现scala的隐式转换
 *         2上下文界定，需要传入一个隐式转换Object
 */
class Pair4[T: Ordering] {
  def bigger(first: T, second: T): T = {
    // implicitly将Ordering跟T关联在一起
    val ord = implicitly[Ordering[T]]
    if (ord.gt(first, second)) first else second
  }
}

object Pair4 {
  def main(args: Array[String]): Unit = {
    import MyPredef.OrderingMan
    val p = new Pair4[Man]
    val r = p.bigger(new Man("laoz", 33), new Man("xiaozhou", 22))
    println(r)
  }
}