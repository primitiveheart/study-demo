package com.zgb

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/10 8:09 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
object ConditionDemo {
  def main(args: Array[String]): Unit = {
    val x = 1;
    val y = if (x > 1) 1 else -1;
    println(y)

    // 支持混合类型表达式
    val z = if (x > 1) 1 else "error"
    // 打印z的值类型是Any，相当是Int和String的父类型
    println(z)

    // 缺少else，相当于if(x>2) else ()
    val m = if (x > 2) 1
    println(m)

    // 在scala中每个表达式都有值，scala中有个Unit类，写做(),相当于java中void
    var n = if (x>2) 1 else ();
    println(n);
  }
}
