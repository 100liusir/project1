package com.cskaoyan.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dis1")
public class DispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先访问dis1，紧接着转发给dis2
        //应当给tomcat发送一个指令， 告诉tomcat，我想调用另外一个servlet
        //传的是另外一个组件dis2的网络路径 /开头
        //转发的时候，其实只能在当前应用下去转发调用组件
        //自动帮你添加应用名
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dis2");
        dispatcher.forward(request, response);
    }
}
