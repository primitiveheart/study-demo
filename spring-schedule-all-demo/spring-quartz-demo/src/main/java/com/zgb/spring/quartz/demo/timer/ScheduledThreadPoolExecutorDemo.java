package com.zgb.spring.quartz.demo.timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/15 8:43 上午
 * @Created By guanbao.zhou
 */
public class ScheduledThreadPoolExecutorDemo {
  public static void main(String[] args) {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
    // 一定延迟之后只执行一次某个任务
//    executorService.schedule(Runnable command, long delay, TimeUnit unit);
    // 会有返回值
//    executorService.schedule(Callable<V> callable, long delay, TimeUnit unit);
    // 一定延迟之后，周期性执行某个任务
    // 间隔是固定的，无论上一个任务是否执行完成
    executorService.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("1 thread name:" + Thread.currentThread().getName());
        throw new RuntimeException("runtime exception");
      }
    }, 0, 3, TimeUnit.SECONDS);
    executorService.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("2 thread name:" + Thread.currentThread().getName());
        try {
          int i = 1 / 0;
        } catch (Exception e) {
          e.printStackTrace();
          throw e;
        }
      }
    }, 0, 3, TimeUnit.SECONDS);

    executorService.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("3 thread name :" + Thread.currentThread().getName());
      }
    }, 0, 2, TimeUnit.SECONDS);
    executorService.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("4 thread name:" + Thread.currentThread().getName());
      }
    }, 0, 2, TimeUnit.SECONDS);
    // 间隔不是固定的，会在周期任务的上一个任务执行完成之后才开始计时，并指定的时间间隔之后才开始执行任务
//    executorService.scheduleWithFixedDelay()
  }
}
