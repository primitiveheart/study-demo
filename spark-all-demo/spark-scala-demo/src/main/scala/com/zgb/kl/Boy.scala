package com.zgb.kl

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/20 11:33 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         将比较规则和类耦合在一起
 */
class Boy(val name: String, var fv: Double) extends Comparable[Boy] {

  override def toString = s"Boy($name, $fv)"

  override def compareTo(o: Boy): Int = {
    (this.fv - o.fv).toInt
  }
}
