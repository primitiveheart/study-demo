package com.zgb

import scala.collection.mutable

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 3:42 下午
 * @Created By guanbao.zhou
 * @author xmly
 *
 *         导入可变集合的set
 *         可变的set，长度和内容都可以改变
 *
 */
object MutableSetDemo {
  def main(args: Array[String]): Unit = {
    // 可变set长度可变,内容可变
    val s1 = mutable.Set(1, 2, 3, 4, 5, 6, 7, 8, 4, 5, 6)
    // 可以追加元素
    s1 += 10
    // 移除一个元素
    s1 -= 4;
    println(s1)
    // 输出结果
    // Set(1, 5, 2, 6, 3, 10, 7, 8)
    val s2 = new mutable.HashSet[String];
    s2 += "a"
    s2 += "b"
    s2 ++= Set("d", "a", "f")
    println(s2)
    // 输出结果：
    // Set(f, d, a, b)

    // LinkedHashSet有序的，按照添加元素的顺序排序
    val ls = new mutable.LinkedHashSet[Int]
    ls += 1
    ls += 2
    ls += 3
    ls += 4
    ls += 3
    println(ls)
    // 输出结果：
    // Set(1, 2, 3, 4)

    // 可排序的set
    val ts = new mutable.TreeSet[Int]()
    ts.add(10)
    ts += 3
    ts += 7
    ts += 2
    println(ts)

  }
}
