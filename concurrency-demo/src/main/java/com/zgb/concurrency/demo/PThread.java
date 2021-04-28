package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/4 10:01 上午
 * @Created By guanbao.zhou
 */
public class PThread extends Thread {
  private P p;

  public PThread(P p) {
    super();
    this.p = p;
  }

  @Override
  public void run() {
    while (true) {
      p.pushService();
    }
  }
}
