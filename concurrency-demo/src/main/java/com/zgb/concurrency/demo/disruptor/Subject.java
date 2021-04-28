package com.zgb.concurrency.demo.disruptor;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/21 上午9:13
 * @Created By guanbao.zhou
 */
public interface Subject {
  void addObserver(Observer observer);

  void deleteObserver(Observer observer);

  void notifyObserver(String content);
}
