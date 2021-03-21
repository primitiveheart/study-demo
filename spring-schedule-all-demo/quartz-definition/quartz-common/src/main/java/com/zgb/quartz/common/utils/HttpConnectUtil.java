package com.zgb.quartz.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 通用接口工具类
 *
 * @author jiawei
 */
public class HttpConnectUtil {
  private static Logger log = LoggerFactory.getLogger(HttpConnectUtil.class);

  /**
   * 发起http请求并获取结果
   *
   * @param requestUrl    请求地址
   * @param requestMethod 请求方式（GET、POST）
   * @param outputStr     提交的数据
   * @return JSONObject(通过JSONObject.get ( key)的方式获取json对象的属性值)
   */
  public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
    String result = null;
    StringBuffer buffer = new StringBuffer();
    try {
      URL url = new URL(requestUrl);
      HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

      // 设置通用的请求属性
      httpUrlConn.setRequestProperty("accept", "*/*");
      httpUrlConn.setRequestProperty("connection", "Keep-Alive");
      httpUrlConn.setRequestProperty("Charset", "utf-8");

      httpUrlConn.setDoOutput(true);
      httpUrlConn.setDoInput(true);
      httpUrlConn.setUseCaches(false);

      // 设置请求方式（GET/POST）
      httpUrlConn.setRequestMethod(requestMethod);

      httpUrlConn.connect();
      // 当有数据需要提交时
      if (null != outputStr) {
        OutputStream outputStream = httpUrlConn.getOutputStream();
        // 注意编码格式，防止中文乱码
        outputStream.write(outputStr.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
      }
      // 将返回的输入流转换成字符串
      InputStream inputStream = httpUrlConn.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

      String str = null;
      while ((str = bufferedReader.readLine()) != null) {
        buffer.append(str);
      }
      bufferedReader.close();
      inputStreamReader.close();
      // 释放资源
      inputStream.close();
      inputStream = null;
      httpUrlConn.disconnect();
      result = buffer.toString();
      //jsonObject = JSONObject.fromObject(buffer.toString());
    } catch (ConnectException ce) {
      log.error("Weixin server connection timed out.");
    } catch (Exception e) {
      log.error("https request error:{}", e);
    }
    return result;
  }

  /**
   * 发起https请求并获取结果
   *
   * @param requestUrl    请求地址
   * @param requestMethod 请求方式（GET、POST）
   * @param outputStr     提交的数据
   * @return 结果字符串
   */
  public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
    String result = null;
    StringBuffer buffer = new StringBuffer();
    try {
//			 // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
//            TrustManager[] tm = { new MyX509TrustManager() };  
//            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
//            sslContext.init(null, tm, new java.security.SecureRandom());  
//            // 从上述SSLContext对象中得到SSLSocketFactory对象  
//            SSLSocketFactory ssf = sslContext.getSocketFactory();  

      URL getUrl = new URL(requestUrl);
      HttpsURLConnection httpUrlConn = (HttpsURLConnection) getUrl.openConnection();
//			 httpUrlConn.setSSLSocketFactory(ssf);  
      // 设置通用的请求属性
//			httpUrlConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
      httpUrlConn.setRequestProperty("accept", "*/*");
      httpUrlConn.setRequestProperty("connection", "Keep-Alive");
      httpUrlConn.setRequestProperty("Charset", "utf-8");
      httpUrlConn.setDoOutput(true);
      httpUrlConn.setDoInput(true);
      httpUrlConn.setUseCaches(false);

      // 设置请求方式（GET/POST）
      httpUrlConn.setRequestMethod(requestMethod);

      if ("GET".equalsIgnoreCase(requestMethod))
        httpUrlConn.connect();
      // 当有数据需要提交时
      if (null != outputStr) {
        OutputStream outputStream = httpUrlConn.getOutputStream();
        // 注意编码格式，防止中文乱码
        outputStream.write(outputStr.getBytes("UTF-8"));
        outputStream.close();
      }
      // 将返回的输入流转换成字符串
      InputStream inputStream = httpUrlConn.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      String str = null;
      while ((str = bufferedReader.readLine()) != null) {
        buffer.append(str);
      }
      bufferedReader.close();
      inputStreamReader.close();
      // 释放资源
      inputStream.close();
      inputStream = null;
      httpUrlConn.disconnect();
      result = buffer.toString();
      //jsonObject = JSONObject.fromObject(buffer.toString());
    } catch (ConnectException ce) {
      log.error(requestUrl + " server connection timed out.");
//			throw new Exception("连接服务器超时");
    } catch (Exception e) {
      log.error(requestUrl + " https request error:{}", e);
//			throw new Exception("HTTPS请求错误");
    }
    return result;
  }

  public static String getIpAddr(HttpServletRequest request) {
    String ipAddress = request.getHeader("x-forwarded-for");
    if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader("Proxy-Client-IP");
    }
    if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getRemoteAddr();
      if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
        ipAddress = "127.0.0.1";
      }
    }
    //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
    if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
      if (ipAddress.indexOf(",") > 0) {
        ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
      }
    }
    return ipAddress;

  }
}
