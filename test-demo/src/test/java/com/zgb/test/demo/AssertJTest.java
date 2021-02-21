package com.zgb.test.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/21 10:18 下午
 * @Created By guanbao.zhou
 */
public class AssertJTest {

  @Test
  public void basicAssertions() {
    assertThat(AssertJDemo.getName()).isEqualTo("AssertJ");
  }

  @Test
  public void chainStringAssertions() {
    assertThat(AssertJDemo.getName()).startsWith("Asse")
            .endsWith("J")
            .isEqualToIgnoringCase("assertj");
  }

  @Test
  public void chainCollectionAssertions(){
    assertThat(AssertJDemo.getList()).hasSize(3)
            .contains("frodo", "sam")
            .doesNotContain("sauron");
  }
}
