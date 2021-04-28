package com.zgb.spring.quartz.demo.timer;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/16 上午11:15
 * @Created By guanbao.zhou
 */
public class DefineThreadPoolExecutor {

  public static void main(String[] args) {
    int corePoolThread = Runtime.getRuntime().availableProcessors();
    int maxPoolThread = corePoolThread;
    long keepAliveTime = 0L;
    BlockingQueue workQueue = new ArrayBlockingQueue(100);
    String name = "long-polling-";
    UserThreadFactory userThreadFactory = new UserThreadFactory(name, false);
    ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolThread, maxPoolThread,
            keepAliveTime, TimeUnit.MILLISECONDS, workQueue, userThreadFactory);

    executor.execute(new Runnable() {
      @Override
      public void run() {
        try {
          // TODO
        } catch (Exception e) {

        }
      }
    });
  }


  static class UserThreadFactory implements ThreadFactory {
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger();
    private final boolean daemon;

    public UserThreadFactory(String namePrefix, boolean daemon) {
      SecurityManager s = System.getSecurityManager();
      this.group = Objects.nonNull(s) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
      this.namePrefix = namePrefix;
      this.daemon = daemon;
    }

    @Override
    public Thread newThread(Runnable task) {
      String name = namePrefix + nextId.getAndIncrement();
      Thread thread = new Thread(this.group, task, name, 0);
      if (this.daemon) {
        thread.setDaemon(daemon);
      }
      return thread;
    }
  }
}
