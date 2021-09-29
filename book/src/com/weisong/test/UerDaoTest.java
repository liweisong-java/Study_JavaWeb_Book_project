package com.weisong.test;

import com.weisong.dao.UserDao;
import com.weisong.dao.impl.UserDaoImpl;
import com.weisong.pojo.User;
import org.junit.Test;

/**
 * @author 李伟松
 * @create 2021-09-14-18:58
 */
public class UerDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername(){
        if (userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword(){
        if (userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或者密码错误，登陆失败");
        }else{
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser(){
        System.out.println( userDao.saveUser(new User(null,"admin","123456","159456@qq.com")));
    }
}
