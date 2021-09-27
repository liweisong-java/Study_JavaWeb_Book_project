package com.weisong.web;

import com.weisong.pojo.User;
import com.weisong.service.UserService;
import com.weisong.service.impl.UserServiceImpl;
import sun.security.util.Password;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李伟松
 * @create 2021-09-22-11:59
 */
public class LoginServlet extends HttpServlet {


    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2、调用userServlet.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        //3.根据login()方法返回结果判断登录是否成功
        //如果等于null，说明登陆失败
        if (loginUser == null){
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //跳回登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //成功
            //跳到成功页面 login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }






    }
}
