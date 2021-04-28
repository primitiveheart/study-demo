package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/4 10:04 上午
 * @Created By guanbao.zhou
 */
public class P {
  private MyStack myStack;

  public P(MyStack myStack) {
    super();
    this.myStack = myStack;
  }

  public void pushService() {
    myStack.push();
  }
}
