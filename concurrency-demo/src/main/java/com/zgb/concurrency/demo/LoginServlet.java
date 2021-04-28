package com.zgb.concurrency.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/4/3 10:28 上午
 * @Created By guanbao.zhou
 */
public class LoginServlet {
  private static String usernameRef;
  private static String passwordRef;

  public static void doPost(String username, String password) {
    try {
      usernameRef = username;
      if (username.equals("a")) {
        Thread.sleep(5000);
      }
      passwordRef = password;
      System.out.println("username= " + usernameRef + " password=" + passwordRef);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ALogin a = new ALogin();
    a.start();
    BLogin b = new BLogin();
    b.start();
  }
}

class ALogin extends Thread {
  @Override
  public void run() {
    LoginServlet.doPost("a", "aa");
  }
}

class BLogin extends Thread {
  @Override
  public void run() {
    LoginServlet.doPost("b", "bb");
  }
}

