package com.zgb.design.adapter;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 9:39 下午
 * @Created By guanbao.zhou
 * 适配器
 */
public class HdmiAdapter implements Hdmi {

  private TypeC typeC;

  public HdmiAdapter(TypeC typeC) {
    this.typeC = typeC;
  }

  @Override
  public void connect() {
    typeC.connect();
  }
}
