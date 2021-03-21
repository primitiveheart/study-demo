package com.zgb.collection;

import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:43 下午
 * @Created By guanbao.zhou
 * 泛型类，T类型就可以在方法中使用
 */
public interface MyTraversableLike<T> {

  /**
   * 泛型方法，在返回值的前面，void的前面<R>
   *
   * @param func
   * @param <R>
   * @return
   */
  <R> List<R> map(MyFunction1<T, R> func);

  /**
   * 对原来集合的数据进行过滤，满足func的留下
   *
   * @param func
   * @return
   */
  List<T> filter(MyFunction1<T, Boolean> func);

  T reduce(MyFunction2<T, T, T> func);
}
