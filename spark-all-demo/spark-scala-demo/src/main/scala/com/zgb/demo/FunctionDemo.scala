package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 12:43 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
object FunctionDemo {

  def m(x : Int): Int ={
    x * x
  }

  def main(args: Array[String]): Unit = {
    // 匿名函数
    (x: Int) =>
      x * x

      // 有名字的函数，其实就是一个变量引用该函数[函数就是一个引用类型，函数就是new的某个类的字段]
      val f = (x: Int) => x * x;

      // 定义变量，可以加类型，也可以不加类型，原因是scala编译器可以自动推断
      val i = 10
      val j: Int = 10

      // 定义函数的时候也加类型，也可以不加
      val f1 = (x: Int, y: Double) => (y, x) // 返回的是一个整体[元组]
      val f2: (Int, Double) => (Double, Int) = (x: Int, y: Double) => (y, x)
      val f3: (Int, Double) => (Double, Int) = (x, y) => (y, x)

      // 定义一个集合
      val arr = Array(1, 3, 4, 5, 6)
      // 定义一个函数
      val ff = (x: Int) => x * x;
      // 将函数作为参数传入到方法中
      val a1 = arr.map(ff)
      // 如果一个函数只在一个方法中使用一次，那么就可以使用匿名函数
      val a2 = arr.map((x: Int) => x * x)
      // 函数中类型可以不加，scala可以自动推断出arr数组中的类型
      val a3 = arr.map((x) => x * x)
      // 如果只有一个参数，小括号也可以省略
      val a4 = arr.map(x => x * x)
      // 函数就是一个非常灵活的运算逻辑，可以灵活的将函数传入到方法中，前提是函数接收到的是类型一致的函数类型
      // 函数式编程的好处：想要做什么，就调用相应的方法【filter、map、flatMap、sortBy】

      // 函数式编程可以支持链式编程，不停的点下去

      // 更加简洁的定义匿名函数的方式，使用神奇的下划线，下划线就相当于每一次循环取出来一个局部变量
      arr.filter(_ % 2 == 0).map(Math.sqrt(_))

      // 函数和方法最大的区别就是，函数可以作为参数传入到方法中[函数本质就是一个引用类型]
      // 将方法名传入到map方法中
      val a5 = arr.map(m)
      // 数组的map方法，要求传入一个函数，输入一个参数，返回一个值
      // 为什么传入一个m可以？
      // 实际上，传入的是一个方法名，scala将其转换成函数，实际上传入的是函数
      // 生成一个函数，函数中调用了m方法
      val f4 = m _
      arr.map(f4)
      arr.map(m _)
  }


}
