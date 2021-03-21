package com.zgb;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2019/10/18 9:27 上午
 * @Created By guanbao.zhou
 */
public class OperationDemo {
  public static void map() {
    SparkConf conf = new SparkConf().setMaster("local").setAppName("spark-demo");
    JavaSparkContext sc = new JavaSparkContext(conf);
    JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4));
    JavaRDD<Integer> result = rdd.map(new Function<Integer, Integer>() {
      @Override
      public Integer call(Integer x) throws Exception {
        return x * x;
      }
    });
    System.out.println(StringUtils.join(result.collect(), ","));
  }

  public static void main(String[] args) {
    map();
  }
}
