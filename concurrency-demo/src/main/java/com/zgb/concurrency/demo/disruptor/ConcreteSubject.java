package com.zgb.concurrency.demo.disruptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/21 上午9:15
 * @Created By guanbao.zhou
 */
public class ConcreteSubject implements Subject {
  private List<Observer> list = new ArrayList<>();

  @Override
  public void addObserver(Observer observer) {
    list.add(observer);
  }

  @Override
  public void deleteObserver(Observer observer) {
    list.remove(observer);
  }

  @Override
  public void notifyObserver(String content) {
      for (Observer observer : list) {
        observer.update(content);
      }
  }
}
