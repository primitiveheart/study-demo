package com.zgb

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/10 8:04 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
object VariableDemo {
  def main(args: Array[String]): Unit = {
    // 使用val定义的变量值是不可变的，相当于java里面final修饰的值
    val i = 1
    // 使用var定义的变量是可变的，在Scala中鼓励使用val
    var s = "hello"
    // Scala编译器会自动优雅的推断出变量的类型，必要的时候可以指定类型
    // 格式：变量名 ： 类型
    var str: String = "world"
  }
}
