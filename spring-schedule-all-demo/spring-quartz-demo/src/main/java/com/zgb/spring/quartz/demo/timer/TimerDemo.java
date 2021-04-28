package com.zgb.spring.quartz.demo.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/10 9:49 下午
 * @Created By guanbao.zhou
 */
public class TimerDemo {
  public static void main(String[] args) {
    // 任务启动
    Timer timer = new Timer();

    for (int i = 0; i < 2; i++) {
      TimerTask task = new FooTask("foo" + i);
      // 任务添加
      timer.schedule(task, new Date(), 2000);
      timer.scheduleAtFixedRate(task, new Date(), 2000);
      // 假设开始时间：12:00:00
      // 预设的执行时间nextExecuteTime 12:00:02, 12:00:04
      // schedule 真正的执行时间 取决于上一个任务的结束时间 executeTime 12:00:03, (少执行任务)
      // scheduleAtFixedRate 严格按照预设的时间 12:00:02,12:00:04执行，(执行时间会乱)
    }
  }
}


class FooTask extends TimerTask {

  private String name;

  public FooTask(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    try {
      System.out.println("name = " + name + ", startTime =" + new Date());
      Thread.sleep(3000);
      System.out.println("name = " + name + ", endTime =" + new Date());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}