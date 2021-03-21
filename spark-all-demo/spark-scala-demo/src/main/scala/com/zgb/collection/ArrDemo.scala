package com.zgb.collection

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:12 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
object ArrDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 5, 6)
    val r1 = arr.reduce((x, y) => x + y);
    println(r1);
    // 输出结果：26
    val r2 = arr.reduceLeft((x, y) => x + y);
    val r3 = arr.reduce(_ + _)


    // 第一个是初始值：100,从左边累计
    val r4 = arr.fold(100)((x, y) => x + y)
    val r5 = arr.foldLeft(100)(_ + _);
    val r6 = arr.foldRight(100)(_ + _)
    println(r4)
    // 输出结果 126

    val r7 = arr.grouped(3);
    println(r7)
    // 输出结果：将集合分成三组
    val r8 = arr.grouped(3).toList
    println(r8)
    // List([I@57536d79, [I@3b0143d3, [I@5a8e6209)
    // 将结果压平
    val r9 = arr.grouped(3).toList.flatten;
    println(r9)
    // 输出结果：List(1, 2, 3, 4, 5, 5, 6)
    val r10 = arr.grouped(3).toList.flatMap(x => x)
    println(r10)
    // 输出结果：List(1, 2, 3, 4, 5, 5, 6)
    // 并行化集合
    val r11 = arr.par.fold(100)(_ + _)
  }
}
