package com.zgb.concurrency.demo.disruptor;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/21 上午9:12
 * @Created By guanbao.zhou
 */
public interface Observer {
  void update(String content);
}
