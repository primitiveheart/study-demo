package com.zgb.collection;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:41 下午
 * @Created By guanbao.zhou
 */
public interface MyFunction1<T, R> {
  /**
   * 定义一个规范，属于一个T类型的参数，返回一个R
   * T和R可以是同一个类型
   *
   * @param r
   * @return
   */
  R apply(T r);
}
