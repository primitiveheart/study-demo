package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/2 3:13 下午
 * @Created By guanbao.zhou
 */
public class ConcurrencyDemo {

  private final static long count = 100001;

  public static void main(String[] args) throws InterruptedException {
    concurrency();
    serial();
  }

  private static void serial() {
    long start = System.currentTimeMillis();
    int a = 0;
    for (long i = 0; i < count; i++) {
      a += 5;
    }

    int b = 0;
    for (long i = 0; i < count; i++) {
      b--;
    }

    long time = System.currentTimeMillis() - start;
    System.out.println("serial : " + time + "ms, b=" + b);
  }

  private static void concurrency() throws InterruptedException {
    long start = System.currentTimeMillis();
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        int a = 0;
        for (long i = 0; i < count; i++) {
          a += 5;
        }
      }
    });
    thread.start();

    int b = 0;
    for (long i = 0; i < count; i++) {
      b--;
    }
    thread.join();
    long time = System.currentTimeMillis() - start;

    System.out.println("concurrency :" + time + " ms, b=" + b);
  }

}
