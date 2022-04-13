package com.cskaoyan.requestServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @program: Day39
 * @description:  打印HTTP请求报文
 *
 *      * requestURL = 访问协议：主机、端口号 + requestURI                  http://localhost:8080/app/request HTTP/1.1
 *                                           /app/request HTTP/1.1
 *      * @param request
 *      * @param response
 *      * @throws ServletException
 *      * @throws IOException
 *      *
 * @author: liuweiming
 * @create: 2022-04-06 10:32
 **/
@WebServlet("/request")
public class ServletRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //利用request提供的方法将http请求报文打印出来

        String method = req.getMethod();//请求方法
        String requestURI = req.getRequestURI();//请求资源
        String requestURL = req.getRequestURL().toString();
        String protocol = req.getProtocol();//版本协议

        System.out.println(method+" "+requestURI+" "+protocol);
        System.out.println(method+" "+requestURL+" "+protocol);

        //获取请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName+":"+headerValue+":");
        }

        //获取请求体

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

