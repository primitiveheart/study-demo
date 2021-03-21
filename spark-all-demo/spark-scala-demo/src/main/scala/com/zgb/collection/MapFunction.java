package com.zgb.collection;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:24 下午
 * @Created By guanbao.zhou
 */
public interface MapFunction {
  /**
   * 定义一个规范，输入一个String，返回一个String
   * @param word
   * @return
   */
  String apply(String word);
}
