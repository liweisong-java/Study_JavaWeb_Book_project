package com.weisong.service;

import com.weisong.pojo.User;

/**
 * @author 李伟松
 * @create 2021-09-14-19:27
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return  如果返回null，说明登录失败
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return  返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);


}
