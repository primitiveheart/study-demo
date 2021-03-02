package com.zgb.mybatis.demo.plugin;

import com.zgb.mybatis.demo.UserDO;
import com.zgb.mybatis.demo.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 12:52 下午
 * @Created By guanbao.zhou
 */
public class ExamplePluginTest {
  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    // 解析
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    try (SqlSession session = sqlSessionFactory.openSession()) {
      UserDO userDO = new UserDO();
      userDO.setId(1);
      userDO.setName("testPlugin");
      userDO.setCity("上海");
      UserMapper mapper = session.getMapper(UserMapper.class);
      mapper.updateUserById(userDO);
    }

  }
}
