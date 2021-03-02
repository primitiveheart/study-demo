package com.zgb.mybatis.demo.plugin;

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
      UserDO userDO = new UserDO();
      userDO.setId(1);
      userDO.setName("testPlugin");
      userDO.setCity("上海");
      UserMapper mapper = session.getMapper(UserMapper.class);
      mapper.updateUserById(userDO);
    }
  }

  public void queryUserPage (UserQuery userQuery) {
//    PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageNum());
//    List<StudentDO> studentsPage = studentDao.listByConditions(userQuery);
//    PageResult<StudentVO> studentVOsPage;
//    try {
//      studentVOsPage = BeanMapperUtils.mapPageByJson(studentsPage);
//    } catch (IOException e) {
//      LOGGER.error(ErrorCodeEnum.COPY_PROPERTIES_ERROR.getMessage(), e);
//      throw new ServiceException(ErrorCodeEnum.COPY_PROPERTIES_ERROR.getCode(),
//              ErrorCodeEnum.COPY_PROPERTIES_ERROR.getMessage(), e);
//    }
  }
}
