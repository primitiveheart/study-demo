package com.zgb.sparksql;

import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 4:25 下午
 * @Created By guanbao.zhou
 */
public class ReadCSVDemo {
  public static void main(String[] args) {
    SparkSession sparkSession = SparkSession.builder()
            .appName("SparkByExample")
            .master("local[1]")
            .getOrCreate();

    RDD<String> rdd = sparkSession.sparkContext().textFile(
            "/Users/xmly/studycode/spark-demo/src/main/resources/csv", 3);
//    rdd.map(f -> f.split)
  }
}
