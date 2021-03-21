package com.zgb.collection;

import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:49 下午
 * @Created By guanbao.zhou
 */
public class MyAdvListTest {
  public static void main(String[] args) {
    MyAdvList<String> words = new MyAdvList<>();
    words.add("Hadoop");
    words.add("Spark");
    words.add("Flink");
    words.add("Hbase");
    words.add("Hive");

    List<String> result = words.map(new MyFunction1<String, String>() {
      @Override
      public String apply(String r) {
        return r.toLowerCase();
      }
    });

    for (String s : result) {
      System.out.println(s);
    }

  }
}
