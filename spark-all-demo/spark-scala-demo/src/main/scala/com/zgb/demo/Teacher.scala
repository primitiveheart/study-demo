package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 12:08 上午
 * @Created By guanbao.zhou
 * @author xmly
 *         scala中的构造非常简单，跟类名交织在一起的叫做主构造器[方法]
 *         用val或var修饰的构造器参数，会成为这个类的成员变量
 */
class Teacher(val name: String, var age :Int, var fv :Double,
              private var account: String = "6222722",
              private[this] var password: String = "123456"){

}

object Teacher {
  def main(args: Array[String]): Unit = {
    val t  = new Teacher("小账", 22,11.2)
  }
}

class People(val name: String) {
  var age: Int = _

  // 对于辅助构造器，是对主构造器的补充和扩展
  def this(name: String, age: Int) {
    // 辅助构造器的第一行一定需要调用主构造器或其它辅助构造器的调用开始
    this(name)
    this.age = age
  }
}

// 如果定义的构造器中参数没有使用var或val修饰，那么就不会成为这个类的成员变量
//class User(val name : String, age : Int) {
//}

// 构造器私有化，只能在伴生对象中初始化
class User2 private(val name: String) {

}
object User2 {
  def main(args: Array[String]): Unit = {
    val u = new User2("ab")
  }
}

class User3 {
  // 相当于在主构造器中的执行逻辑
  println("1234")
}

// 小写的object，代表一个静态对象，也是单例对象，满足一定条件就是伴生对象
// 1.存放工具的方法和常量
// 2.高效的共享单个不可变的实例
// 3.单例模式
object User3 {
  // 该部分相当与java中静态块
  val const = 5
  while(const > 0) {

  }

  def main(args: Array[String]): Unit = {
    // 单例对象，不需要new，用【类名.方法】调用对象中的方法
    val u = User3;
    println(u)
    val u1 = User3
    // u和u1是同一个实例，在一个java进程中，只有一份
    println(u1)
  }

}