package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/3 10:02 上午
 * @Created By guanbao.zhou
 */
public class MyThread extends Thread {
  @Override
  public void run() {
    super.run();
    System.out.println("MyThread");
    System.out.println("run = " + this.isAlive());
  }

  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    System.out.println("begin = " + myThread.isAlive());
    myThread.start();
    System.out.println("end = " + myThread.isAlive());
  }
}
