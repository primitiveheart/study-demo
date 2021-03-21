package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 9:58 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object KlDemo {
  // 柯里化
  // 定义一个方法，可以有多括号传递参数
  def kl(x : Int)(y: Int)(z : Int) : Int = {
    x + y
  }

  def m(x: Int, y : Int) : Int = {
    x + y
  }
}
