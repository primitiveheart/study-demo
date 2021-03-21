package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:50 下午
 * @Created By guanbao.zhou
 * @author xmly
 * Scala的泛型，scala的泛型用[]
 * 逆变：-A 方法的输入参数类型
 * 协变：+R 方法返回值的类型
 */
trait MyFunction2[-A, -B , +C] {
  def apply(a: A, b: B) : C
}
