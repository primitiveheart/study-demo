package com.zgb

import org.apache.spark.sql.SparkSession

/**
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/3 11:49 下午
 * @Created By guanbao.zhou
 * @author xmly
 */
object SparkDemo {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .master("yarn-client")
      .appName("New SS")
      .config("spark.executor.instances", "10")
      .config("spark.executor.memory", "10g")
      .getOrCreate()
  }
}
