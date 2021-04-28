package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/3 10:39 上午
 * @Created By guanbao.zhou
 */
public class MyThread1 extends Thread {
  private int i = 5;

  @Override
  public void run() {
    System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    MyThread1 run = new MyThread1();
    Thread t1 = new Thread(run);
    Thread t2 = new Thread(run);
    Thread t3 = new Thread(run);
    Thread t4 = new Thread(run);
    Thread t5 = new Thread(run);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
  }
}
