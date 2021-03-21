package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/21 2:18 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object MyPredef {
  implicit val boy2OrderedBoy2 = (boy: Boy2) => new Ordered[Boy2] {
    override def compare(that: Boy2): Int = {
      (boy.fv - that.fv).toInt
    }
  }

  implicit object OrderingMan extends Ordering[Man] {
    override def compare(x: Man, y: Man): Int = {
      x.age - y.age
    }
  }
}
