package com.zgb.web.common.ex;

import com.zgb.web.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/1/18 5:24 下午
 * @Created By guanbao.zhou
 * 异常统一处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * 业务异常
   *
   * @param businessException
   * @return
   */
  @ExceptionHandler(BusinessException.class)
  public CommonResponse handleBusinessException(BusinessException businessException) {
    return CommonResponse.error(businessException.getMessage(), businessException.getCode());
  }

  @ExceptionHandler(Exception.class)
  public CommonResponse handleException(Exception e) {
    return CommonResponse.error("系统繁忙,请稍后再试");
  }
}
