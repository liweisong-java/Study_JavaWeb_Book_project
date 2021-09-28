package com.weisong.test;

import java.lang.reflect.Method;

/**
 * @author 李伟松
 * @create 2021-09-28-12:06
 */
public class UserServletTest {
    public void login(){
        System.out.println("这是login()方法调用了");
    }
    public void regist(){
        System.out.println("这是regist()方法调用了");
    }
    public void updateUser(){
        System.out.println("这是updateUser()方法调用了");
    }
    public void updateUserPassword(){
        System.out.println("这是updateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            //通过action业务鉴别字符串，获取相应的业务方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            //通过目标业务方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
