package com.zgb.test.demo.controller;

import com.zgb.test.demo.pojo.vo.UserVO;
import com.zgb.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/22 1:36 下午
 * @Created By guanbao.zhou
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("user")
  public UserVO getUserById(Integer id) {
    return userService.getUserById(id);
  }

  @PostMapping("save")
  public String save(@RequestBody UserVO userVO) {
    userService.save(userVO);
    return "成功!";
  }
}
