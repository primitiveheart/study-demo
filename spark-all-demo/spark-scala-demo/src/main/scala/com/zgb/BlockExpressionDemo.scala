package com.zgb

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/10 8:14 上午
 * @Created By guanbao.zhou
 * @author xmly
 */
object BlockExpressionDemo {
  def main(args: Array[String]): Unit = {
    val x = 0;
    // 在scala中{}中包含一系列表达式，块中最后一个表达式的值就是块的值
    val result = {
      if (x < 0) {
        -1
      } else if (x >= 1) {
        1
      } else {
        "error"
      }
    }
    // result的值就是块表达式的结果
    println(result);
  }
}
