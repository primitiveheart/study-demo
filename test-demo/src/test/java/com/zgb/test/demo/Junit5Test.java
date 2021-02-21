package com.zgb.test.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/21 9:14 下午
 * @Created By guanbao.zhou
 */
@DisplayName("Junit5 单元测试")
public class Junit5Test {

  @Test
  public void standardAssertions(){
    assertEquals(2, JunitDemo.add(1,1));
    assertEquals(4, JunitDemo.multiply(2, 2),
            "The optional failure message is now the last parameter");
    assertTrue('a' > 'b', () -> "Assertion messages can be lazily evaluated -- "
            + "to avoid constructing complex messages unnecessarily.");
  }

  @Test
  void testOnlyOnCiServer() {
    assumeTrue("CI".equals(System.getenv("ENV")));
    // remainder of test
  }

  @Test
  void testInAllEnvironments() {
    assumingThat("CI".equals(System.getenv("ENV")),
            () -> {
              // perform these assertions only on the CI server
              assertEquals(2, JunitDemo.add(1, 1));
            });

  }

  @DisplayName("用不同的参数测试多次，基本数据源")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  public void testWithValueSource(int args) {
    assertTrue(args >0 && args < 4);
  }

  @DisplayName("用不同的参数测试多次，csv数据源")
  @ParameterizedTest
  @CsvSource({"1,One", "2,Two", "3,Three"})
  public void testWithCsvSource(long id, String name) {
    assertTrue(id >0 && id < 4);
  }

  @BeforeAll
  public static void init() {
    System.out.println("初始化数据");
  }

  @AfterAll
  public static void cleanup() {
    System.out.println("清理数据");
  }

  @BeforeEach
  public void tearUp() {
    System.out.println("当前测试方法开始");
  }

  @AfterEach
  public void tearDown() {
    System.out.println("当前测试方法结束");
  }

  @DisplayName("我的第一个测试")
  @Test
  void testFirstTest() {
    System.out.println("我的第一个测试开始测试");
  }

  @DisplayName("我的第二个测试")
  @Test
  void testSecondTest() {
    System.out.println("我的第二个测试开始测试");
  }
}
