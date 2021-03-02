package com.zgb.sparksql;

import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 4:02 下午
 * @Created By guanbao.zhou
 */
public class ReadTextFileDemo {
  public static void main(String[] args) {
    SparkSession sparkSession = SparkSession.builder()
            .appName("SparkByExample")
            .master("local[1]")
            .getOrCreate();

    RDD<String> rdd = sparkSession.sparkContext().textFile("/Users/xmly/studycode/spark-demo/src/main/resources" +
            "/txt", 3);
//    rdd.foreach();
  }
}
