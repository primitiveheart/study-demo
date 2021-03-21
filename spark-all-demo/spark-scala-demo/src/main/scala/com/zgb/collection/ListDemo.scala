package com.zgb.collection

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:05 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object ListDemo {
  def main(args: Array[String]): Unit = {
    val lis = List(1,2,3,4,5,6,7,8,9)
    // 折叠：有初始值(无特定顺序)
    val lis1 = lis.par.fold(100)(_+_)
    // 折叠：有初始值(有特定顺序)
    val list2 = lis.par.foldLeft(100)(_+_);

    val l1 = List(5,6,7,8)
    val l2 = List(1,2,3,4)
    // 求并集
    val r1 = l1.union(l2);
    // 求交集
    val r2 = l1.intersect(l2);
    // 求差集
    val r3 = l1.diff(l2);
  }
}
