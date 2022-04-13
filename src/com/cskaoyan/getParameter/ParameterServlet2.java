package com.cskaoyan.getParameter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @program: Day39
 * @description:    获取多个请求参数
 * @author: liuweiming
 * @create: 2022-04-06 15:18
 **/

@WebServlet("/param2")
public class ParameterServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            String key = names.nextElement();
            //这个方法无法获取到提交多个请求参数的情形
            //也就是无法获取到checkbox类型的参数
            //String value = request.getParameter(key);

            String[] values = req.getParameterValues(key);
            System.out.println(key + ":" + Arrays.toString(values));
        }
    }
}

