package com.zgb.sparksql;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import scala.collection.mutable.Seq;

import java.util.Arrays;
import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 3:34 下午
 * @Created By guanbao.zhou
 */
public class RDDParallelizeDemo {
  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
            .master("local[1]")
            .appName("SparkByExample")
            .getOrCreate();

    // 生成java spark context
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    JavaRDD<String> lines = jsc.parallelize(Arrays.asList("pandas", "i likes pandas"));
    long count = lines.count();
    System.out.println("个数" + count);
    List<String> take = lines.take(1);
    System.out.println(take.size());
  }
}
