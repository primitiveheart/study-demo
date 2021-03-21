package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:01 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object ImplicitValueDemo {

  // 定义一个用implicit修饰的参数
//  implicit val abc : Int = 666;

  def m1(x : Int) : Int = {
    x * x
  }

  def m2(x : Int = 8) : Int = {
    x * x
  }

  // 柯里化方法，后面的括号参数有默认值
  // 柯里化方法中普通的默认值不能使用
  def kl1(x: Int)(y : Int = 8) : Int = {
    x + y
  }

  // 柯里化结合隐私值
  def kl2(x: Int)(implicit y : Int = 8) : Int = {
    x + y
  }

  def main(args: Array[String]): Unit = {
    val r1 = m1(8)
    println(r1)
    // 输出结果：64

    // 方法中的参数有默认值，可以不用传参
    val r2 = m2();
    println(r2)
    // 输出结果：64

    // 如果方法传参，会优化使用传递的参数
    val r3 = m2(10)
    println(r3)
    // 输出结果：100

    // 柯里化方法中普通的默认值不能使用
    // 报错
//    val r4 = kl1(20)
//    println(r4)

    // 柯里化结合隐私值，默认值可以使用
    // scala的柯里化结合隐私参数，程序中有用implicit修饰的参数，程序执行时，会到程序的执行环境(Context)
    // 找用implicit修饰的且参数类型一致参数，有就传递过来使用，不需要变量名一致
    // 如果传递参数，优先使用传递的参数，如果有implicit修饰的类型一致的参数，用该隐式值，如果还没有，用默认值
    val r5 = kl2(20)
    println(r5)

    // 导入隐式参数
    import MyContext.abcd
    val r7 = kl2(20)
    println(r7)

    // 如果是类，先要new实例，然后在导入隐式值
    val mc = new MyClass
//    import mc.abcdef
    val r8 = kl2(20)
    println(r8)

    // 在程序中，有多个用implicit修饰的类型一致的隐式值，会出错
  }
}
