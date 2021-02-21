package com.zgb.test.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/21 10:40 下午
 * @Created By guanbao.zhou
 */
public class HamcrestTest {
  @Test
  public void test() {
    // 匹配字符串以 XX 开头
    assertThat("myStringOfNote", startsWith("my"));
    // 匹配是否包含指定字符串
    assertThat("myStringOfNote", containsString("ring"));
    // 基于传入对象的 equals 方法匹配方式，如果是数组比较每个元素是否相等。
    assertThat("foo", equalTo("foo"));
    assertThat(new String[]{"foo", "bar"}, equalTo(new String[]{"foo", "bar"}));
    // 匹配所有指定的匹配项，可指定多个匹配条件
    assertThat("myValue", allOf(startsWith("my"), containsString("Val")));
    // 匹配其中任意一个匹配项，可指定多个匹配条件
    assertThat("myValue", anyOf(startsWith("foo"), containsString("Val")));
    // 两个选项都匹配
    assertThat("fab", both(containsString("a")).and(containsString("b")));
    // 匹配其中任意一个匹配项
    assertThat("fan", either(containsString("a")).or(containsString("b")));
    // 自定义描述匹配 describedAs(参数1：自定义描述，可以使用占位符%0,%1,%2...参数2：匹配器参数3：自定义描述中需要替换的变量按先后顺序匹配);
    assertThat(120, describedAs("自定义期望值：%0", equalTo(110), 110));
    // 输出：Expected: 自定义期望值：<110>
    // 匹配现实 Iterable 接口类中的每个元素是否符合要求
    assertThat(Arrays.asList("bar", "baz"), everyItem(startsWith("ba")));
    // 匹配对象是属于哪个类
    assertThat(new Object(), instanceOf(Object.class));
    // isA：instanceOf 的快捷方式
    assertThat(new Object(), isA(Object.class));
  }
}
