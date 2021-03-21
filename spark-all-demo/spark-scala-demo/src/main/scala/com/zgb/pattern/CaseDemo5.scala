package com.zgb.pattern

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 5:18 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object CaseDemo5 extends App {
  val tup = (2, 3, 5)
  tup match {
    case (1, x, y) => println(s"hello 123 $x , $y")
    case (_, z, 5) => println(z)
    case _ => println("else")
  }
  // 输出结果: 3

}
