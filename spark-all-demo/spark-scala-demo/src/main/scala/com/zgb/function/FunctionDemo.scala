package com.zgb.function

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:04 上午
 * @Created By guanbao.zhou
 * @author xmly
 *        定义一个方法，参数为函数
 */
object FunctionDemo {
  def m(f : Int => String, x: Int) {
    val res = f(x);
    println(res)
  }

  def m2(f: (Int, Double) => Double, a : Int, b :Int): Unit = {
    val res = f(a, b);
    println(res)
  }

  def main(args: Array[String]): Unit = {
    m(x => String.valueOf(x) + "suffix", 1);
    m2((x, y) => x.toDouble + y, 1,3);
  }
}
