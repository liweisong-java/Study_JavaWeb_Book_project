package com.weisong.service.impl;

import com.weisong.dao.impl.UserDao;
import com.weisong.dao.impl.UserDaoImpl;
import com.weisong.pojo.User;
import com.weisong.service.UserService;

/**
 * @author 李伟松
 * @create 2021-09-14-19:39
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null){
            //等于null，说明没有查到，没查到表示可用
            return false;
        }
        return true;
    }
}
