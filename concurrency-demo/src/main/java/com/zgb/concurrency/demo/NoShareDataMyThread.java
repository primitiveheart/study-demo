package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/3 10:10 上午
 * @Created By guanbao.zhou
 */
public class NoShareDataMyThread extends Thread {
  private int count = 5;

  public NoShareDataMyThread(String name) {
    super();
    // 设置线程名称
    this.setName(name);
  }

  @Override
  public void run() {
    super.run();
    while (count > 0) {
      count--;
      System.out.println(" 由 " + currentThread().getName() + " 计算, count=" + count);
    }
  }

  public static void main(String[] args) {
    NoShareDataMyThread a = new NoShareDataMyThread("A");
    NoShareDataMyThread b = new NoShareDataMyThread("B");
    NoShareDataMyThread c = new NoShareDataMyThread("C");
    a.start();
    b.start();
    c.start();
  }
}
