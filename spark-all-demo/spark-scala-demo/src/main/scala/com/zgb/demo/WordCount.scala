package com.zgb.demo

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/15 11:03 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object WordCount {
  def main(args: Array[String]): Unit = {
    val lines = List("hello tom hello jerry", "hello tom hello", "hello tom");

    // 切分压平，相当于map再flatten
    val words: List[String] = lines.flatMap(line => line.split(" "))

    // 将单词和1组合，放到元组中
    val wordAndOne: List[(String, Int)] = words.map(w => (w, 1))

    // 根据单词分组
    val grouped: Map[String, List[(String, Int)]] = wordAndOne.groupBy(tp => tp._1)

    // 将单词和长度取出，放到一个元组中
//    val wordCounts: Map[String, Int] = grouped.map(tp => (tp._1, tp._2.size))
    val wordCounts: Map[String, Int] = grouped.mapValues(m => m.size)

    // 排序，map不支持排序，转为list
    val listWordCounts: List[(String, Int)] = wordCounts.toList;
    // 排序
    val result: List[(String, Int)] = listWordCounts.sortBy(tp => -tp._2)

    println(result)

  }
}
