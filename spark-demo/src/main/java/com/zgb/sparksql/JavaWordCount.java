package com.zgb.sparksql;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 7:34 下午
 * @Created By guanbao.zhou
 */
public class JavaWordCount {

  private static final Pattern SPACE = Pattern.compile(" ");

  public static void main(String[] args) {
    // 初始化spark
    SparkSession spark = SparkSession.builder()
            .master("local[1]")
            .appName("JavaWordCount")
            .getOrCreate();

    JavaRDD<String> lines = spark.read().textFile("/Users/xmly/studycode/spark-demo/src/main/java/com/zgb/sparksql" +
            "/JavaWordCount.java").javaRDD();
    JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());
    JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));
    JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);
    List<Tuple2<String, Integer>> output = counts.collect();
    for (Tuple2<?, ?> tuple : output) {
      System.out.println(tuple._1() + " : " + tuple._2());
    }
    spark.stop();
  }
}
