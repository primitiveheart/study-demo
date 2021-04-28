package com.zgb.web.common.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解表示一个方法返回的对象将被包装到一个CommonResponse的data字段中
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/28 下午10:19
 * @Created By guanbao.zhou
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Response {
}
