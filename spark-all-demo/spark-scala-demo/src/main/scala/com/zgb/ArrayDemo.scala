package com.zgb

import scala.collection.mutable.ArrayBuffer

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 3:12 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object ArrayDemo {
  def main(args: Array[String]): Unit = {
    // 初始化一个长度为8的定长数组，其所有元素均为0
    val arr1 = new Array[Int](8);
    // 直接打印定长数组，内容为数组的hashcode值
    println(arr1)
    // 将数组转换成数组缓冲，就可以看到原数组中的内容
    // toBuffer会将数组转换长数组缓冲
    println(arr1.toBuffer)

    // 注意，如果new，相当于调用了数组的apply方法，直接为数据赋值
    // 初始化一个长度为10的定长数组
    val arr2 = Array[Int](10)
    println(arr2.toBuffer)

    // 定义一个长度为3的定长数组
    val arr3 = Array("hadoop", "storm", "spark")
    // 使用()来访问元素
    println(arr3(2))

    // 变长数组(数组缓冲)
    // 如果想使用数组缓冲，需要导入import scala.collection.mutable.ArrayBuffer 包
    val ab = ArrayBuffer[Int]()
    // 向数组缓冲的尾部追加一个元素
    ab += 5
    ab += 7
    ab += 8
    ab += 5

    println(ab)

    // -= 是从左开始删除第一个出现的元素
    ab -= 5

    println(ab)

    // 改变ArrayBuffer中元素的值
    ab(1) = 80
    // 从指定的位置前面插入元素
    ab.insert(1, 9, 10)
    println(ab)

    // 从指定位置[包括指定的位置]删除多个元素
    ab.remove(1, 3)
    println(ab)

    val r = ab.sum
    println(r)

  }
}
