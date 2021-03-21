package com.zgb.sparksql;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 9:10 下午
 * @Created By guanbao.zhou
 */
public class MapDemo {
  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
            .master("local[1]")
            .appName("SparkByExample")
            .getOrCreate();
//    spark.sparkContext().wholeTextFiles("").toJavaRDD()
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    JavaRDD<Integer> rdd = jsc.parallelize(Arrays.asList(1, 2, 3, 4));
    JavaRDD<Integer> result = rdd.map(item -> item * item);
    System.out.println(StringUtils.join(result.collect(), ","));
  }
}
