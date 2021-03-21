package com.zgb.pattern

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 5:29 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object OptionDemo {
  def main(args: Array[String]): Unit = {
    val map = Map("a" -> 1, "b" -> 2)
    val o: Option[Int] = map.get("c")
    println(o)

    val v = o match {
      case Some(x) => x
      case None => 0
    }
    println(v)

    // 推荐的方式
    val v1 = map.getOrElse("c", 0)
    println(v1)
    // 输出结果：None
    //0
    //0
  }
}
