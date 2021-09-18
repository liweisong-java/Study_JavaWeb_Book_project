package com.weisong.test;

import com.weisong.pojo.User;
import com.weisong.service.UserService;
import com.weisong.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author 李伟松
 * @create 2021-09-14-19:52
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser(){
        userService.registUser(new User(null,"xiaoyao1314","666666","15645@qq.com"));
        userService.registUser(new User(null,"ai1314","666666","1561536@qq.com"));
    }
    @Test
    public void login(){
        System.out.println(userService.login(new User(null,"xiaoyao1314","666666",null)));

    }
    @Test
    public void existsUsername(){
        if (userService.existsUsername("xiaoyao1314")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}
