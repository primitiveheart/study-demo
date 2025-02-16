package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/19 上午8:38
 * @Created By guanbao.zhou
 */
public class ThreadState {
  public static void main(String[] args) {
    new Thread(new TimeWaiting(), "TimeWaitingThread").start();
    new Thread(new Waiting(), "WaitingThread").start();
    new Thread(new Blocked(), "BlockedThread-1").start();
    new Thread(new Blocked(), "BlockedThread-2").start();
  }

  static class TimeWaiting implements Runnable {
    @Override
    public void run() {
      while (true) {
        SleepUtils.second(100);
      }
    }
  }

  static class Waiting implements Runnable {

    @Override
    public void run() {
      while (true) {
        synchronized (Waiting.class) {
          try {
            Waiting.class.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  static class Blocked implements Runnable {
    @Override
    public void run() {
      synchronized (Blocked.class) {
        while (true) {
          SleepUtils.second(100);
        }
      }
    }
  }
}
