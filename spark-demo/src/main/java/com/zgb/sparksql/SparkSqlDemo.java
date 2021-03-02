package com.zgb.sparksql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2019/10/21 8:30 上午
 * @Created By guanbao.zhou
 */
public class SparkSqlDemo {
  public static void main(String[] args) {
    // spark 配置
    SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("spark-demo");
    // spark 上下文
    JavaSparkContext sc = new JavaSparkContext(sparkConf);
//    SQLContext sqlContext = new HiveContext(sc);
  }
}
