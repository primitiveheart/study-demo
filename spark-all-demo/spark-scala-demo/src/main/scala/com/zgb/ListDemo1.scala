package com.zgb

import scala.collection.mutable.ListBuffer

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 4:03 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         不可变的List，长度不可变，内容不可变
 */
object ListDemo1 {

  def main(args: Array[String]): Unit = {
    val lst = List(1, 3, 2, 4, 7, 5, 6, 9)

    val r: Int = lst(5)
    println(r)
    // 输出结果：5

    // 生成一个新的排序的List
    val lst2 = lst.sorted
    println(lst2)
    // List(1, 2, 3, 4, 5, 6, 7, 9)

    // 不可变list没法追加
    val lst3 = lst :+ 10;
    println(lst3)
    println(lst)
    // 输出结果：
    // List(1, 3, 2, 4, 7, 5, 6, 9, 10)
    // List(1, 3, 2, 4, 7, 5, 6, 9)

    val lb = new ListBuffer[Int]
    lb += 5;
    lb ++ List(7, 1, 2, 3, 4, 5)
    println(lb)
  }

}
