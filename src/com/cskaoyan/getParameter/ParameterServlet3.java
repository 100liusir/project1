package com.cskaoyan.getParameter;

import com.cskaoyan.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: Day39
 * @description:    获取多个请求参数
 * @author: liuweiming
 * @create: 2022-04-06 15:18
 **/

@WebServlet("/param3")
public class ParameterServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//解决中文乱码

        //可以使用一个工具类，来帮助我们完成赋值操作
        //找jar包
        User user = new User();
        try {
            //实际上也是利用反射来实现的
            BeanUtils.populate(user,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(user);


    }
}

