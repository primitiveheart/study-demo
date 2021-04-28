package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/3 10:17 上午
 * @Created By guanbao.zhou
 */
public class ShareDataMyThread extends Thread {
  private int count = 5;

  @Override
  synchronized public void run() {
    super.run();
    count--;
    System.out.println(" 由 " + currentThread().getName() + " 计算, count=" + count);
  }

  public static void main(String[] args) {
    ShareDataMyThread myThread = new ShareDataMyThread();
    Thread a = new Thread(myThread, "A");
    Thread b = new Thread(myThread, "B");
    Thread c = new Thread(myThread, "C");
    Thread d = new Thread(myThread, "D");
    Thread e = new Thread(myThread, "E");
    a.start();
    b.start();
    c.start();
    d.start();
    e.start();
  }
}
