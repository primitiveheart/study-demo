package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 4:36 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object StudentDemo {
  def main(args: Array[String]): Unit = {
    val st = new Student
    println(st.age)
    println(st.id)
    println(st.name)
    println(st.faceValue)
  }
}
