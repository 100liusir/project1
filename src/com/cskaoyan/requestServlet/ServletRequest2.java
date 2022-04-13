package com.cskaoyan.requestServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Day39
 * @description:    获取客户机和服务器主机的相关信息
 * @author: liuweiming
 * @create: 2022-04-06 10:58
 **/

@WebServlet("/request2")
public class ServletRequest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取服务器信息
        String localAddr = req.getLocalAddr();

        //获取服务器监听的端口号
        int localPort = req.getLocalPort();

        //获取客户机信息
        String remoteAddr = req.getRemoteAddr();

        //获取客户端使用的端口号
        int remotePort = req.getRemotePort();

        System.out.println(localAddr+"--------->"+localPort);
        System.out.println(remoteAddr+"-------->>"+remotePort);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

