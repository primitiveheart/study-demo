package com.zgb.kl

import java.io.File

import scala.io.Source

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 10:22 下午
 * @Created By guanbao.zhou
 * @author xmly
 * 1.隐式转换的本质，就是对类和方法的增强和扩展
 * 2.隐式转换就是装饰模式的特殊表现形式，scala编译器在语法上就支持，只有用一个implicit关键字就可以了
 * 3.隐式转换就是在编译时，取上下文中取查找【类型是否一致，转换另外的类型就有其他的方法了】
 */
class RichFile(val file: File) {
  def read(): String = {
    Source.fromFile(file).mkString
  }
}

object RichFile {
  def main(args: Array[String]): Unit = {
    // 读取指定文件中的全部内容，返回一个字符串
    val file = new File("/Users/xmly/studycode/study-demo/spark-all-demo/spark-scala-demo/a.txt")

    val richFile = new RichFile(file)
    val content = richFile.read()
    println(content)

    import MyContext.file2RichFile
    // 不用RichFile包装，直接调用read方法
    // 程序在编译时，发现调用file的read方法，但是file上没有read方法，但是scala会在程序的上下进行查找
    // 查找有没有一个方法或函数，可以将自身转换成另外一种类型，这个另外的类型定义了read方法，参数的个数和返回值一种
    // 隐式转换优化使用返回相同类型的函数
    val content1 = file.read();
    println(content1)
  }
}
