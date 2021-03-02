package com.zgb.sparksql;

import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/1/3 7:49 上午
 * @Created By guanbao.zhou
 */
public class DateFormatDateToString {
  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder().master("local").appName("SparkByExample.com").getOrCreate();
    System.out.println(spark);

  }
}
