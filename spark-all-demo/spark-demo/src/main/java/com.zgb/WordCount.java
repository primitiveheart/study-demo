package com.zgb;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2019/10/18 7:59 上午
 * @Created By guanbao.zhou
 */
public class WordCount {
  public static void main(String[] args) {
    // 创建一个java的Spark context
    SparkConf conf = new SparkConf().setMaster("local").setAppName("spark-demo");
    JavaSparkContext sc = new JavaSparkContext(conf);
    // 读入数据
    JavaRDD<String> input = sc.textFile("/Users/xmly/studycode/spark-demo/src/main/java/com.zgb/WordCount.java");
    // 切分单词
    JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {
      @Override
      public Iterator<String> call(String s) throws Exception {
        return Arrays.asList(s.split(" ")).iterator();
      }
    });
    // 转换键值对并计数
    JavaPairRDD<String, Integer> counts = words.mapToPair(
            new PairFunction<String, String, Integer>() {
              @Override
              public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s, 1);
              }
            }).reduceByKey(new Function2<Integer, Integer, Integer>() {
      @Override
      public Integer call(Integer x, Integer y) throws Exception {
        return x + y;
      }
    });
    System.out.println();
    // 将统计出来的单词总数存入到一个文本文件，引发求值
    counts.saveAsTextFile("result.txt");
  }
}
