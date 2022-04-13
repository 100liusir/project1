package com.cskaoyan.work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 关于反射的作业：
 * 1.要求要能够理解反射的执行原理，执行过程，项目中要用
 *      （利用set方法完整复制）
 *      阿里巴巴编程规范、谷歌编程规范
 * 2.如果代码实在理解不了，没有关系，忽略即可
 * 回头做一个实验 dbutils mybatis set
 * 约定大于配置
 */

@WebServlet("/work2")
public class WorkServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //将表单里面提交过来的请求参数全部封装到一个对象中，不要用BeanUtils
        //如何去写？可以仿造着BeanUtils的格式来写
        User user = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();

        try {
            ReflectionUtils.toBean(user, parameterMap);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
