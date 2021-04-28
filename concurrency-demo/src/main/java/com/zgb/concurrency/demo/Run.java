package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/4 10:10 上午
 * @Created By guanbao.zhou
 */
public class Run {
  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    P p = new P(myStack);
    C c = new C(myStack);
    PThread pThread = new PThread(p);
    CThread cThread = new CThread(c);
    pThread.start();
    cThread.start();

  }
}
