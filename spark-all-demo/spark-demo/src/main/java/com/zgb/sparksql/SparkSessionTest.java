package com.zgb.sparksql;

import org.apache.spark.sql.SparkSession;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 3:10 下午
 * @Created By guanbao.zhou
 */
public class SparkSessionTest {
  public static void main(String[] args) {
    SparkSession sparkSession = SparkSession.builder()
            .master("local[1]")
            .appName("SparkByExample")
            .getOrCreate();

    System.out.println("First SparkContext: ");
    System.out.println("App Name :" + sparkSession.sparkContext().appName());
    System.out.println("Deploy Node :" + sparkSession.sparkContext().deployMode());
    System.out.println("Master :" + sparkSession.sparkContext().master());
  }
}
