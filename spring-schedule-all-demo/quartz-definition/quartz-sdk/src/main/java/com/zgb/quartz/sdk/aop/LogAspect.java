package com.zgb.quartz.sdk.aop;

import com.alibaba.fastjson.JSONObject;
import com.zgb.quartz.core.annotation.ControllerLogAnnotation;
import com.zgb.quartz.core.annotation.ServiceLogAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 切点类   
 * @author wion
 *
 */
@Aspect    
@Component  
public class LogAspect {
	private final Logger logger = LoggerFactory.getLogger(LogAspect.class);  
	
	public LogAspect(){
    }
	//Service层切点    
    @Pointcut("@annotation(com.ffxl.cloud.annotation.ServiceLogAnnotation)")    
    public  void serviceAspect() {
    }
     
    //Controller层切点    
    @Pointcut("@annotation(com.ffxl.cloud.annotation.ControllerLogAnnotation)")    
    public  void controllerAspect() {    
    }
     
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作  
     *  
     * @param joinPoint 切点  
     */
    @Before("controllerAspect()")
    public  void doBefore4control(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //请求的IP    
        String ip = request.getRemoteAddr();    
         try {    
            //*========控制台输出=========*//    
            System.out.println("=====control 前置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));    
            System.out.println("请求IP:" + ip);    
            System.out.println("=====前置通知结束=====");    
        }  catch (Exception e) {
            //记录本地异常日志    
            logger.error("==前置通知异常==");
            logger.error("异常信息:{}", e.getMessage());    
        }
    }
    
    /**  
     * 前置通知 用于拦截service层记录方法调用
     *  
     * @param joinPoint 切点  
     */
    @Before("serviceAspect()")
    public  void doBefore4service(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //获取请求ip    
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串    
        String params = "";    
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
                params += JSONObject.toJSON(joinPoint.getArgs()[i]).toString() + ";";
            }  
        }
        try {    
            /*========控制台输出=========*/    
            System.out.println("=====service 前置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));    
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
             
        }  catch (Exception ex) {    
            //记录本地异常日志    
            logger.error("==异常通知异常==");    
            logger.error("异常信息:{}", ex.getMessage());    
        }    
    }
     
    @AfterReturning(pointcut="serviceAspect()", returning="returnValue")
    public  void after4service(JoinPoint joinPoint, Object returnValue) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        //获取请求ip    
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串    
        String params = "";
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
                params += JSONObject.toJSON(joinPoint.getArgs()[i]).toString() + ";";
            }  
        }
        try {    
            /*========控制台输出=========*/    
            System.out.println("=====service 后置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));    
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
            System.out.println("返回值为：" + JSONObject.toJSON(returnValue).toString());
        }  catch (Exception ex) {    
            //记录本地异常日志    
            logger.error("==异常通知异常==");    
            logger.error("异常信息:{}", ex.getMessage());    
        }
    }
     
    /**  
     * 异常通知 用于拦截service层记录异常日志  
     *  
     * @param joinPoint  
     * @param e  
     */    
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {    
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //获取请求ip    
        String ip = request.getRemoteAddr();    
        //获取用户请求方法的参数并序列化为JSON格式字符串    
        String params = "";    
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
                 params += JSONObject.toJSON(joinPoint.getArgs()[i]).toString() + ";";
            }  
        }
        try {    
            /*========控制台输出=========*/    
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());    
            System.out.println("异常信息:" + e.getMessage());    
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));    
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
             
            System.out.println("=====异常通知结束=====");    
        }  catch (Exception ex) {    
            //记录本地异常日志    
            logger.error("==异常通知异常==");    
            logger.error("异常信息:{}", ex.getMessage());    
        }    
         /*==========记录本地异常日志==========*/    
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);    
     
    }    
     
     
    /**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getServiceMthodDescription(JoinPoint joinPoint)
             throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ServiceLogAnnotation. class).description();
                     break;    
                }    
            }    
        }    
         return description;    
    }    
     
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ControllerLogAnnotation. class).description();
                     break;    
                }    
            }    
        }    
         return description;    
    }    
}
