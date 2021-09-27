package com.weisong.web;

import com.weisong.pojo.User;
import com.weisong.service.UserService;
import com.weisong.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李伟松
 * @create 2021-09-14-21:54
 */
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查验证码是否正确      ==写死，要求验证码为abcde
        if ("abcde".equalsIgnoreCase(code)){
            //正确
                //3.检查用户名是否可用
            if (userService.existsUsername(username)){
                //不可用
                    //跳回到注册页面
                System.out.println("用户名[" + username + "]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registUser(new User(null,username,password,email));
                //可用
                    //调用Service保存到数据库
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }
        }else{
            System.out.println("验证码[" + code + "]错误");
            //不正确
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
                //跳回注册页面

        }

    }
}
