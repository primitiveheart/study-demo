package com.zgb.test.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/22 8:28 上午
 * @Created By guanbao.zhou
 */
//@ExtendWith(MockitoExtension.class)
public class MockitoTest {

//  @BeforeAll
//  public void initMock() {
//    MockitoAnnotations.openMocks(this);
//  }

  @Test
  public void mockObject() {
    // 模拟LinkedList 的对象
    LinkedList mockedList = mock(LinkedList.class);
    // 此时调用get方法，是会返回null，因为还没有对方法调用的返回值做模拟
    System.out.println(mockedList.get(1));
  }

  @Test
  public void mockMethodInvokeReturn() {
    // 模拟LinkedList 的对象
    LinkedList mockedList = mock(LinkedList.class);
    // 模拟获取第一个元素时，返回字符串first
    when(mockedList.get(0)).thenReturn("first");
    // 此时打印输出first
    System.out.println(mockedList.get(0));
  }

  @DisplayName("方法有返回值，抛出异常")
  @Test
  public void mockMethodThrowException() {
    // 模拟LinkedList 的对象
    LinkedList mockedList = mock(LinkedList.class);
    // 模拟获取第二个元素时，抛出RuntimeException
    when(mockedList.get(1)).thenThrow(new RuntimeException());
    // 此时将会抛出RuntimeException
    System.out.println(mockedList.get(1));
  }

  @DisplayName("方法没有返回值，抛出异常")
  @Test
  public void mockMethodNoReturnThrowException() {
    // 模拟LinkedList 的对象
    LinkedList mockedList = mock(LinkedList.class);
    doThrow(new RuntimeException()).when(mockedList).clear();
    // 此时将会抛出RuntimeException
    mockedList.clear();
  }

  @Test
  public void spyRealObject() {
    List list = new LinkedList<>();
    List spy = spy(list);
    //模拟获取列表的大小，返回100
    when(spy.size()).thenReturn(100);

    // 调用真实对象list的add方法
    spy.add("one");
    spy.add("two");

    // 输出 “one”，获取列表的第一个元素
    System.out.println(spy.get(0));

    // 输出100，获取列表的大小(该大小已经打桩)
    System.out.println(spy.size());

    //optionally, you can verify
    verify(spy).add("one");
    verify(spy).add("two");

  }

  @Test
  public void verifyBehaviorTest() {
    // 模拟list对象
    List mockedList = mock(List.class);

    // 使用mock对象
    mockedList.add("one");
    mockedList.clear();

    // 验证
    verify(mockedList).add("one");
    verify(mockedList).clear();
  }

}
