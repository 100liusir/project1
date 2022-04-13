package com.cskaoyan.getParameter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Day39
 * @description:    获取请求参数
 * @author: liuweiming
 * @create: 2022-04-06 15:18
 **/

@WebServlet("/param1")
public class ParameterServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收get方法请求参数
        String username = req.getParameter("username");
        String category = req.getParameter("category");
        System.out.println(username);
        System.out.println(category);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收post请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

    }
}

