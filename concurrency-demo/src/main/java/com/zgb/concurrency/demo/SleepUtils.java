package com.zgb.concurrency.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/19 上午8:41
 * @Created By guanbao.zhou
 */
public class SleepUtils {
  public static final void second(int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {

    }
  }
}
