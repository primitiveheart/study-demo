package com.zgb.collection;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/19 9:00 下午
 * @Created By guanbao.zhou
 */
public interface MyFunction2<T, W, R> {
  R apply(T t, W w);
}
