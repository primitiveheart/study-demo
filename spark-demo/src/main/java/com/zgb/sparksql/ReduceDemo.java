package com.zgb.sparksql;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 9:40 下午
 * @Created By guanbao.zhou
 */
public class ReduceDemo {
  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
            .master("local[1]")
            .appName("SparkByExample")
            .getOrCreate();
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    JavaRDD<Integer> rdd = jsc.parallelize(Arrays.asList(1, 2, 3, 4));
    Integer sum = rdd.reduce(new Function2<Integer, Integer, Integer>() {
      @Override
      public Integer call(Integer x, Integer y) throws Exception {
        return x + y;
      }
    });
    System.out.println(sum);
  }
}
