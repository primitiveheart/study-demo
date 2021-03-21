package com.zgb.pattern

import scala.util.Random

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 5:00 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object CaseDemo1 extends App {
  var arr = Array("zhouzhouzhozu", "sdfsfd", "ssfd")

  val name = arr(Random.nextInt(arr.length))

  println(name)

  name match {
    case "zhouzhouzhozu" => println("zhouzhouzhozu")
    case "sdfsfd" => {
      println("sdfsfd -----")
    }
    case _ => println("default")
  }

}
