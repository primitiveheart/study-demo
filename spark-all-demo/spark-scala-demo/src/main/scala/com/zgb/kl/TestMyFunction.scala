package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:52 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object TestMyFunction {
  def main(args: Array[String]): Unit = {
    val func = new MyFunction2[Int, Double, (Double, Int)] {
      override def apply(a: Int, b: Double): (Double, Int) = {
        (b, a)
      }
    }

    val tp = func.apply(5, 7.7)
    println(tp)
  }
}
