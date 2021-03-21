package com.zgb

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/10 8:18 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
/**
 * 静态类，静态类中的方法和变量都是静态的
 */
object ForDemo {
  // 静态方法
  def main(args: Array[String]): Unit = {
    val str = "ABCDEFG";
    for (s <- str) {
      println(s);
    }

    println("=========")

    // 取出字符串对应脚本的字符
    val c = str(0)
    println(c)

    println("=========")

    val arr = Array(1,3,5,7,9);
    for (i <- arr) println(i)
    println("=========")

    // 0 to 6 代表[0，6]的有序期间
    for (i <- 0 to 6) {
      println(str(i))
    }
    println("=========")

    // until 代表(]的有序期间
    for (i <- 0 until str.length) {
      println(str(i))
    }

    println("=========")
    // 每个生成器都可以带一个条件，注意：if前面没有分号
    for (i <- 1 to 3; j <- 1 to 3 if i!=j) {
      print((10 * i + j) + "")
    }

    println("=========")
    // 如果for循环体yield开始，则该循环会构建出一个集合，每次迭代生成集合中的一个值
    val v = for (i <- 1 to 10) yield i * 10
    println(v)
  }
}
