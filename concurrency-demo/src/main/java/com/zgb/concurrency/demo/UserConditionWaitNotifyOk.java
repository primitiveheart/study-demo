package com.zgb.concurrency.demo;

import java.time.Year;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/4 11:04 上午
 * @Created By guanbao.zhou
 */
public class UserConditionWaitNotifyOk {
  public static void main(String[] args) {
    MyService myService = new MyService();
    ThreadA threadA = new ThreadA(myService);
    threadA.start();
    ThreadB threadB = new ThreadB(myService);
    threadB.start();
  }
}

class ThreadA extends Thread {
  private MyService myService;

  public ThreadA(MyService myService) {
    this.myService = myService;
  }

  @Override
  public void run() {
    super.run();
    myService.await();
  }
}

class ThreadB extends Thread {
  private MyService myService;

  public ThreadB(MyService myService) {
    this.myService = myService;
  }

  @Override
  public void run() {
    myService.signal();
  }
}

class MyService {
  private Lock lock = new ReentrantLock();
  public Condition condition = lock.newCondition();

  public void await() {
    lock.lock();
    try {
      System.out.println("await 时间为: " + System.currentTimeMillis());
      condition.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void signal() {
    lock.lock();
    try {
      System.out.println("Signal 时间为:" + System.currentTimeMillis());
      condition.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}