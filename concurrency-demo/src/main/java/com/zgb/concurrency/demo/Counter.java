package com.zgb.concurrency.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/4 4:45 下午
 * @Created By guanbao.zhou
 */
public class Counter {
  private AtomicInteger atomicI = new AtomicInteger(0);
  private int i = 0;

  public static void main(String[] args) {
    final Counter cas = new Counter();
    List<Thread> ts = new ArrayList<>();
    Long start = System.currentTimeMillis();
    for (int j = 0; j < 100; j++) {
      Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 10000; i++) {
            cas.count();
            cas.safeCount();
          }
        }
      });
      ts.add(t);
    }
    for (Thread t : ts) {
      t.start();
    }

    for (Thread t : ts) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(cas.i);
    System.out.println(cas.atomicI.get());
    System.out.println(System.currentTimeMillis() - start);
  }

  private void safeCount() {
    for (; ; ) {
      int i = atomicI.get();
      boolean suc = atomicI.compareAndSet(i, ++i);
      if (suc) {
        break;
      }
    }
  }

  private void count() {
    i++;
  }
}
