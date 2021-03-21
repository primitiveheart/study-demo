package com.zgb.pattern

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 5:09 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object CaseDemo3 extends App {
  val arr = Array(1, 2, 7, 0)
  arr match {
    case Array(1, 3, x, y) => println(s"x: $x, y: $y")
    case Array(1, 2, 7, y) => println(s"only 0 y :$y")
    case Array(1, _*) => println("0 ...")
    case _ => println("something else")
  }
  // 输出结果 only 0 y :0
}
