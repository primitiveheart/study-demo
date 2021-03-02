package com.zgb.sparksql;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import java.sql.Driver;
import java.util.Properties;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/4 9:04 上午
 * @Created By guanbao.zhou
 */
public class JDBCSaveDemo {
  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
            .master("local[1]")
            .appName("SparkByExample")
            .getOrCreate();
    Dataset<Row> peopleDF =
            spark.read().format("json").load("/Users/xmly/studycode/spark-demo/src/main/resources/json/people.json");
    peopleDF.show();
//    peopleDF.write().format("jdbc")
//            .mode(SaveMode.Append)
//            .option("url", "jdbc:mysql://localhost:3306")
//            .option("user", "root")
//            .option("driver", "com.mysql.jdbc.Driver")
//            .option("dbtable","test.peoples")
//            .save();
    Properties properties = new Properties();
    properties.put("user", "root");
    properties.put("driver", "com.mysql.jdbc.Driver");
    peopleDF.write()
            .mode(SaveMode.Append)
            .jdbc("jdbc:mysql://localhost:3306", "test.peoples", properties);
  }
}
