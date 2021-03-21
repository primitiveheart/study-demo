package com.zgb.sparksql;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.sources.In;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 10:01 下午
 * @Created By guanbao.zhou
 */
public class AggregateDemo {
  static class AvgCount implements Serializable {
    public int total;
    public int num;

    public AvgCount(int total, int num) {
      this.total = total;
      this.num = num;
    }

    public double avg() {
      return total / (double) num;
    }
  }

  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
            .master("local[1]")
            .appName("SparkByExample")
            .getOrCreate();
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    JavaRDD<Integer> rdd = jsc.parallelize(Arrays.asList(1, 2, 3, 4));

    Function2<AvgCount, Integer, AvgCount> addAndCount = new Function2<AvgCount, Integer, AvgCount>() {
      @Override
      public AvgCount call(AvgCount avgCount, Integer x) throws Exception {
        avgCount.total += x;
        avgCount.num += 1;
        return avgCount;
      }
    };

    Function2<AvgCount, AvgCount, AvgCount> combine = new Function2<AvgCount, AvgCount, AvgCount>() {
      @Override
      public AvgCount call(AvgCount avgCount, AvgCount avgCount2) throws Exception {
        avgCount.total += avgCount2.total;
        avgCount.num += avgCount2.num;
        return avgCount;
      }
    };
    AvgCount initial = new AvgCount(0, 0);
    AvgCount result = rdd.aggregate(initial, addAndCount, combine);
    System.out.println(result.avg());

  }
}
