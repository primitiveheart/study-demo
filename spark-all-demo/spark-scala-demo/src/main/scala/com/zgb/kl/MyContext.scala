package com.zgb.kl

import java.io.File


/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:17 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object MyContext {
  implicit val abcd: Int = 7777

  // 定义一个方法，将file转成RichFile
  // 就是事先将File包装成RichFile
  implicit def file2RichFile(file : File): RichFile = new RichFile(file)

  // 优先使用隐式转换函数，没有找到对应的函数，再找方法
  implicit val fileToRichFile = (file: File) => {
    println("Function invoke")
    new RichFile(file)
  }
}
