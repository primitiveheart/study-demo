package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/4 10:07 上午
 * @Created By guanbao.zhou
 */
public class C {
  private MyStack myStack;

  public C(MyStack myStack) {
    this.myStack = myStack;
  }

  public void popService() {
    System.out.println("pop= " + myStack.pop());
  }
}

