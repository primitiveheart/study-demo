package com.zgb.test.demo;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/21 11:26 下午
 * @Created By guanbao.zhou
 */
public class JsonAssertTest {
  @Test
  public void test() throws JSONException {
    String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
    String actual = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\"," +
            "\"fish\"]}],pets:[]}";
    JSONAssert.assertEquals(expected, actual, false);
  }
}
