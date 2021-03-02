package com.zgb.sparksql;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;
import java.util.Collections;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/4 9:41 上午
 * @Created By guanbao.zhou
 */
public class DataSetDemo {
  static class Person implements Serializable {
    private String name;
    private Integer age;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }
  }

  public static void main(String[] args) {

    SparkSession spark = SparkSession.builder()
            .master("local[1]")
            .appName("SparkByExample")
            .getOrCreate();
    Person person = new Person();
    person.setName("Andy");
    person.setAge(32);

    Encoder<Person> personEncoder = Encoders.bean(Person.class);
    Dataset<Person> javaBeanDS = spark.createDataset(
            Collections.singletonList(person),
            personEncoder
    );
  }
}
