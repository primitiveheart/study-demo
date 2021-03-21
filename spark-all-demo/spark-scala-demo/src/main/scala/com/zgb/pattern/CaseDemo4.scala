package com.zgb.pattern

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 5:13 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object CaseDemo4 extends App {
  val list = List(0, 5, 6)
  println(list.head)
  println(list.tail)

  list match {
    case 0 :: Nil => println("only 0")
    case x :: y :: Nil => println(s"x $x y $y")
    case 0 :: a => println(s"0... $a")
    case _ => println("something else ")
  }
  // 输出结果：0
  //List(5, 6)
  //0... List(5, 6)

}
