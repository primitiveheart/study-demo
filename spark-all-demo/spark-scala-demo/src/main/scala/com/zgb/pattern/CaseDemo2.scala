package com.zgb.pattern

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 5:05 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object CaseDemo2 extends App {
  val arr = Array("hello", 1, -2.0, CaseDemo2, 2L)
  val elem = arr(0)

  elem match {
    case x: Int => println("Int :" + x)
    case y: Double if (y >= 0) => println("Double " + y)
    case z: String => println("String " + z)
    case CaseDemo2 => {
      println("case demo 2")
    }
    case _ => {
      println("default")
    }
  }
}
