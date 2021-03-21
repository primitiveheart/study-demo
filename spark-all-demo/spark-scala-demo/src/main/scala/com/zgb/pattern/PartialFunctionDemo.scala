package com.zgb.pattern

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 5:33 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object PartialFunctionDemo {

  def pm: PartialFunction[String, Int] = {
    case "one" => {
      println("one case")
      1
    }
    case "two" => println(2)
      2
    case _ => println("default")
      -1
  }

  def func2(num: String): Int = num match {
    case "one" => 1
    case "two" => 2
    case _ => -1
  }
}
