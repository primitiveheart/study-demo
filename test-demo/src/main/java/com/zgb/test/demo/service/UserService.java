package com.zgb.test.demo.service;

import com.zgb.test.demo.dao.UserMapper;
import com.zgb.test.demo.pojo.entity.UserDO;
import com.zgb.test.demo.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/22 1:41 下午
 * @Created By guanbao.zhou
 */
@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public UserVO getUserById(Integer id) {
    UserDO userDB =  userMapper.getUserById(id);
    UserVO vo = new UserVO();
    BeanUtils.copyProperties(userDB, vo);
    return vo;
  }

  public void save(UserVO userVO) {
    UserDO userDO = new UserDO();
    BeanUtils.copyProperties(userVO, userDO);
    userMapper.save(userDO);
  }
}
