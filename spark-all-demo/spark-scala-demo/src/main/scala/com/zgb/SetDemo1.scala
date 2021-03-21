package com.zgb

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 3:35 下午
 * @Created By guanbao.zhou
 * @author xmly
 * immutable.Set
 *         scala 中导入的set是不可变的Set，set中内容的长度都不可以改变
 *         不可变的set只能读取数据，不能修改
 */
object SetDemo1 {
  def main(args: Array[String]): Unit = {
    // 无序去重
    val s1 = Set(1, 2, 3, 4, 5, 6, 7, 8, 4, 5, 6)

    // 不可以改变内容
    println(s1)
    // 输出结果：
    // Set(5, 1, 6, 2, 7, 3, 8, 4)

    // 判断一个数是否在s1存在
    val bool = s1.contains(5);
    val bool2 = s1(5)
    println(bool)
    println(bool2)
    // 遍历set中的元素
    for (s <- s1) {
      println(s);
    }


  }
}
