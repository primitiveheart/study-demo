package com.zgb

import scala.collection.immutable.TreeMap
import scala.collection.mutable

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 3:54 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         可变的map，长度和内容都可变
 */
object MutableMap {
  def main(args: Array[String]): Unit = {
    // 定义一个不可变的map
    val m1 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4, "e" -> 5, "f" -> 6)
    m1("a") = 100
    m1.put("aaa", 111)
    m1 += "ccc" -> 333
    m1 += (("ddd", 444))
    println(m1)
    // 输出结果
    // Map(ccc -> 333, e -> 5, aaa -> 111, b -> 2, d -> 4, a -> 100, c -> 3, f -> 6, ddd -> 444)

    // 删除元素
    m1 -= "ddd";
    m1.remove("ccc");
    println(m1);
    // 输出结果
    // Map(e -> 5, aaa -> 111, b -> 2, d -> 4, a -> 100, c -> 3, f -> 6)

    m1 ++= Map(("www", 999), "zzz" -> 100);
    println(m1);


    val hashMap = new mutable.HashMap[String, Int]();
    // 按照插入的属性排序
    val lhm = new mutable.LinkedHashMap[String, Int]
    // 按照key的类型的默认顺序进行排序
    val tm = new TreeMap[String, Int]()
  }
}
