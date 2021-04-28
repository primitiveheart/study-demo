package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/3 11:05 上午
 * @Created By guanbao.zhou
 */
public class MyThread2 extends Thread {
  @Override
  public void run() {
    super.run();
    for (int i = 0; i < 500000; i++) {
      System.out.println("i=" + (i + 1));
    }
  }

  public static void main(String[] args) {
    try {
      MyThread2 myThread2 = new MyThread2();
      myThread2.start();
      Thread.sleep(2000);
      myThread2.interrupt();
    } catch (InterruptedException e) {
      System.out.println("main catch");
      e.printStackTrace();
    }
  }
}
