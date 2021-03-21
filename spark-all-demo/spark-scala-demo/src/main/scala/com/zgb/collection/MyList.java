package com.zgb.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:23 下午
 * @Created By guanbao.zhou
 */
public class MyList {
  private List<String> words;

  public MyList(List<String> words) {
    this.words = words;
  }

  public List<String> map(MapFunction func) {
    // 定义一个新集合，转换后的数据
    List<String> handleList = new ArrayList<>();
    // 循环老的list
    for (String word : words) {
      // 应用外部的传入的逻辑
      String handleWord = func.apply(word);
      // 将新的单词添加新的List中
      handleList.add(handleWord);
    }
    // 返回新的List
    return handleList;
  }
}
