package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 12:28 上午
 * @Created By guanbao.zhou
 * @author xmly
 *         trait 类似java 8中的interface
 *         里面可以定义没有实现的方法，也定义有实现的方法
 */
trait Flyable {
  //没有实现的方法
  def fly(): Unit
}
