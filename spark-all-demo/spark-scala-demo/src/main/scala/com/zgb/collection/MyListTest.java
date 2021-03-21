package com.zgb.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:21 下午
 * @Created By guanbao.zhou
 */
public class MyListTest {
  public static void main(String[] args) {
    List<String> words = Arrays.asList(new String[]{"hadoop", "Spark", "Hbase", "Flink","Hive"});

    // java中List没有map方法[做映射]，现在想扩展一个map方法，用装饰的方式，在包装类中定义一个map方法
    MyList myList = new MyList(words);
    List<String> handleList = myList.map(new MapFunction() {
      @Override
      public String apply(String word) {
        return word.toLowerCase();
      }
    });

    for (String word : handleList) {
      System.out.println(word);
      // 输出结果
      // hadoop
      // spark
      // hbase
      // flink
      // hive
    }

  }
}
