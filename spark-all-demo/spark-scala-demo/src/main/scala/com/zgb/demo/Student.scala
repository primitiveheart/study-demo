package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/14 4:32 下午
 * @Created By guanbao.zhou
 * @author xmly
 *         在scala中，类并不用声明为public
 *         scala源文件中可以包含多个类，所有这些类都具有公有可见性
 */
class Student {
  // 有getter方法，但没有setter方法
  // 相当于java中final修饰的变量
  val id: String = "u1001"
  // 既有getter方法，又有setter方法
  var name: String = "老赵"
  // 下划线代表对应类型的默认值，必须指定变量的类型
  var age: Int = _
  var faceValue = 999.9
  // 类私有字段，只能在类的内部使用
  private var nickname:String = "tom"

  // 用private修饰的成员变量，只能在类的内部和伴生对象中使用
  private[this] val pet = "小强"

  // private 和private[this]同样可以修饰方法
  // 类和伴生对象中的属性和方法都可以用访问权限控制修饰符
  // 类和伴生对象可以相互访问private修饰的变量和方法
  // private[this] 如果定义在类中定义，就只能在类的内部使用
  // private[this] 如果定义在object中定义，就只能在object的内部使用
}

/**
 * 伴生对象
 * 1用object定义，object的名字和类名一致
 * 2object和class在用一个.scala文件中
 */
object Student {

  // 一个静态变量，所有的类的实例的共享的
  private val nation: String = "中国"

}

//private[demo]包访问权限，只能在demo包和其子包中访问
private[demo] class User {

}
