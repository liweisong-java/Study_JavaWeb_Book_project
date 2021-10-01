package com.weisong.utils;

import com.weisong.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.naming.event.ObjectChangeListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author 李伟松
 * @create 2021-09-28-14:32
 */
public class WebUtils {
    public static Object copyParamToBean(Map value, Object bean){
        try {
            System.out.println("注入之前：" + bean);
            /**
             * 把多有请求的参数都注入到user对象中
             */
            BeanUtils.populate(bean,value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为int类型
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
