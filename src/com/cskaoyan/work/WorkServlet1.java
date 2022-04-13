package com.cskaoyan.work;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Enumeration;

/**
 * @program: Day38
 * @description:
 * @author: liuweiming
 * @create: 2022-04-07 12:23
 **/
@WebServlet("/work1")
public class WorkServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        StringBuffer buffer = new StringBuffer();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String method = req.getMethod();
        String requestURI = req.getRequestURI();
        String protocol = req.getProtocol();

        buffer.append(username+" "+password);
        buffer.append(method+" "+requestURI+" "+protocol);

        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()){
            String headerName = names.nextElement();
            String headerValue = req.getHeader(headerName);
            buffer.append(headerName+":"+headerValue);
        }

        String text = buffer.toString();
        //把content里面的内容写入到硬盘上一个文件中 SE IO流
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("text1.txt");
        FileOutputStream outputStream = new FileOutputStream(new File(realPath));

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(text);

        outputStreamWriter.close();
        outputStream.close();
        outputStreamWriter.flush();

    }
}
