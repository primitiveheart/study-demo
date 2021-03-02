package com.zgb.mybatis.demo;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 10:39 上午
 * @Created By guanbao.zhou
 */
public class TestDemo {
  public static void main(String[] args) throws IOException {
    xmlMethod();
  }


  private static SqlSessionFactory buildSqlSessionFactory() throws IOException {
    DataSource dataSource = createPooledDataSource();
    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    Environment environment = new Environment("development", transactionFactory, dataSource);
    Configuration configuration = new Configuration(environment);
    configuration.addMapper(UserMapper.class);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    return sqlSessionFactory;
  }

  private static PooledDataSource createPooledDataSource() throws IOException {
    PooledDataSource ds = new PooledDataSource();
    ds.setDriver("com.mysql.cj.jdbc.Driver");
    ds.setUrl("jdbc:mysql://127.0.0.1:3306/test");
    ds.setUsername("root");
    ds.setPassword("root");
    return ds;
  }

  private static void xmlMethod() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    // 解析
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    method1(sqlSessionFactory);
    method1(sqlSessionFactory);
  }

  private static void method1(SqlSessionFactory sqlSessionFactory) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 采用statementId
    UserDO userDO = sqlSession.selectOne("com.zgb.mybatis.demo.UserMapper.selectUser", 1);
  }

  private static void method2(SqlSessionFactory sqlSessionFactory) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      UserMapper mapper = session.getMapper(UserMapper.class);
      UserDO userDO = mapper.selectUser(1);
    }
  }
}
