package com.zgb.web.common.ex;

public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = -7610666750107941464L;

  private int code;

  public BusinessException(int code) {
    super();
    this.code = code;
  }

  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }

  public int getCode() {
    return this.code;
  }

}