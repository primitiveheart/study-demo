package com.zgb.mybatis.demo.page;

import com.google.protobuf.ServiceException;
import com.zgb.mybatis.demo.UserDO;
import com.zgb.mybatis.demo.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 6:53 下午
 * @Created By guanbao.zhou
 */
public class PageTest {
  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    // 解析
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    try (SqlSession session = sqlSessionFactory.openSession()) {
      UserMapper mapper = session.getMapper(UserMapper.class);
      UserQuery userQuery = new UserQuery();
      userQuery.setName("te");
      userQuery.setPageNum(1);
      userQuery.setPageSize(1);
      queryUserPage(mapper, userQuery);
    }
  }

  public static void queryUserPage (UserMapper userMapper, UserQuery userQuery) {
    PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageNum());
    List<UserDO> userPage = userMapper.listByConditions(userQuery);
    System.out.println(userPage.size());
//    PageResult<UserDO> studentVOsPage;
//    try {
//      studentVOsPage = BeanMapperUtils.mapPageByJson(userPage);
//    } catch (IOException e) {
      // ...
//    }
  }
}
