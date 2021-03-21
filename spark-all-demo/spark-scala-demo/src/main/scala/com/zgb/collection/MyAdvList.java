package com.zgb.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 8:40 下午
 * @Created By guanbao.zhou
 * 1.具备ArrayList所有的功能
 * 2.扩展了map、filter、reduce等方法
 * 3.支持链式编程
 * 4.支持传入多种数据类型：泛型
 */
public class MyAdvList<T> extends ArrayList<T> implements MyTraversableLike<T> {

  @Override
  public <R> MyAdvList<R> map(MyFunction1<T, R> func) {
    // 定义一个新的List
    MyAdvList<R> handleList = new MyAdvList<>();
    // 循环老的list
    for (T t : this) {
      // 应用外部传入的逻辑
      R r = func.apply(t);
      // 将新的数据放入到新的List中
      handleList.add(r);
    }
    // 返回新的List
    return handleList;
  }

  @Override
  public MyAdvList<T> filter(MyFunction1<T, Boolean> func) {
    // 定义一个新的List
    MyAdvList<T> handleList = new MyAdvList<>();
    // 循环老的list
    for (T t : this) {
      // 应用外部传入的逻辑
      Boolean flag = func.apply(t);
      if (flag) {
        // 满足条件加入新的List
        handleList.add(t);
      }
    }
    return handleList;
  }

  @Override
  public T reduce(MyFunction2<T, T, T> func) {
    // 定义一个sum
    T sum = null;
    // 定义一个boolen类型
    Boolean isFirst = true;
    // 取出原来的List中的原始元素
    for (T t : this) {
      if (isFirst) {
        sum = t;
        isFirst = Boolean.FALSE;
      } else {
        // 应用传进来的函数，进行运算
        sum = func.apply(sum, t);
      }
    }
    return sum;
  }
}
