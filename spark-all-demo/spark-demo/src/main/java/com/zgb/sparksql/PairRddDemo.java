package com.zgb.sparksql;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/4 8:04 上午
 * @Created By guanbao.zhou
 */
public class PairRddDemo {
  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
            .master("local[1]")
            .appName("SparkByExample")
            .getOrCreate();
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    JavaRDD<String> lines = jsc.parallelize(Arrays.asList("name;age", "Jorge;30", "Bob;32"));

    JavaPairRDD<String, String> result = lines.mapToPair(s -> {
      String[] parts = s.split(";");
      return new Tuple2<>(parts[0], parts[1]);
    }).cache();
    System.out.println(result.collectAsMap());

  }
}
