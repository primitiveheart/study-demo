package com.zgb.quartz.common.constant;

import com.zgb.quartz.common.config.CommonProperties;

/**
 * 常量
 */
public class Const {
  //---------------------平台各应用标识常量----------------------------------------------------

  /**
   * get请求
   */
  public static final String REQUEST_METHOD_GET = "GET";
  /**
   * post请求
   */
  public static final String REQUEST_METHOD_POST = "POST";
  /**
   * 验证码
   */
  public static final String SESSION_SECURITY_CODE = "sessionSecCode";
  /**
   * 登陆用户
   */
  public static final String SESSION_USER = "sessionUser";
  /**
   * 当前菜单
   */
  public static final String SESSION_MENU_LIST = "sessionMenuList";
  /**
   * 当前等级最高角色
   */
  public static final String SESSION_MIN_ROLE = "sessionMinRole";
  /**
   * 系统类型
   */
  public static final String SESSION_SYS_TYPE = "sessionSysType";

  /**
   * 通用状态关键字
   */
  public static String STATUS = "status";
  /**
   * 通用状态关键字
   */
  public static String TAG = "tag";
  /**
   * 通用状态关键字
   */
  public static String CATEGORY_MODEL = "platform_model";

  //状态
  /**
   * 未发布
   */
  public static String STATUS_NO_PUBLIST = "no_publish";
  /**
   * 已发布
   */
  public static String STATUS_PUBLIST = "publish";
  /**
   * 删除
   */
  public static String STATUS_DELETE = "delete";

  //批量操作功能操作
  /**
   * 发布
   */
  public static final String OPERATE_PUBLISH = "publish";
  /**
   * 下架
   */
  public static final String OPERATE_REMOVE = "remove";
  /**
   * 推到主页
   */
  public static final String OPERATE_PUSH = "push";
  /**
   * 取消推送到主页
   */
  public static final String OPERATE_CANCLE_PUSH = "cancle_push";
  /**
   * 删除
   */
  public static final String OPERATE_DELETE = "delete";

  /**
   * app常量
   */
  public static String APP = "app";

  /**
   * wxs api对应的签名开关
   */
  public static final String WXS_API_URL_SIGN = CommonProperties.commonProperties.getProperty("wxs.api.url.sign");
  /**
   * fxf api对应的签名开关
   */
  public static final String FXF_API_URL_SIGN = CommonProperties.commonProperties.getProperty("fxf.api.url.sign");
  /**
   * 定时任务调用url
   */
  public static final String QUARTZ_JOB_URL = CommonProperties.commonProperties.getProperty("quartz.job.url");
}
