package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/4 10:08 上午
 * @Created By guanbao.zhou
 */
public class CThread extends Thread {
  private C c;

  public CThread(C c) {
    this.c = c;
  }

  @Override
  public void run() {
    while (true) {
      c.popService();
    }
  }

}

