package com.weisong.web;

import com.weisong.pojo.User;
import com.weisong.service.UserService;
import com.weisong.service.impl.UserServiceImpl;
import com.weisong.test.UserServletTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 李伟松
 * @create 2021-09-27-22:21
 */
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * 处理注册的业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

                //把回显信息保存到request域中
                req.setAttribute("msg","用户名已存在！！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registUser(new User(null,username,password,email));
                //可用
                //调用Service保存到数据库
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }
        }else{
            //把回显信息保存到request域中
            req.setAttribute("msg","验证码错误！！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("验证码[" + code + "]错误");
            //不正确
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            //跳回注册页面

        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            //通过action业务鉴别字符串，获取相应的业务方法反射对象
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
//            System.out.println(method);
            //通过目标业务方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
