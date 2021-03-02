package com.zgb.sparksql;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 对每一个输入元素生成多个输出元素
 *
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 9:23 下午
 * @Created By guanbao.zhou
 */
public class FlatMapDemo {
  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
            .appName("SparkByExample")
            .master("local[1]")
            .getOrCreate();
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    JavaRDD<String> lines = jsc.parallelize(Arrays.asList("hello world", "hi"));
    JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
      @Override
      public Iterator<String> call(String s) throws Exception {
        return Arrays.asList(s.split(" ")).iterator();
      }
    });
    System.out.println(words.first());
  }
}
