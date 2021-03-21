package com.zgb.function

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:10 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         什么是函数？
 *         函数式是一个引用类型，即是一个接口的实例，函数中有一个apply方法，调用f(10)或f.apply(10)
 *         引用可以作为参数传入到方法中
 */
object FunctionInDepth {

  val f2: Function2[Int, Double, Double] = (x : Int, y : Double) => x + y
  val ff  = new Function2[Int, Double, (Double, Int)] {
    override def apply(v1: Int, v2: Double): (Double, Int) = {
      (v2,v1)
    }
  }

  def main(args: Array[String]): Unit = {
    val tuple = ff.apply(5,7.7)
    println(tuple)
    // 输出结果：
  }
}
