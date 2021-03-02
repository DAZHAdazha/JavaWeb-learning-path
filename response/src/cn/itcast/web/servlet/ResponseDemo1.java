package cn.itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 完成重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问responseDemo1,会自动跳转到responseDemo2资源

        System.out.println("demo1....");

//        //1.设置状态码为302
//        response.setStatus(302);
//        //2设置响应头location
//        response.setHeader("location","/responseDemo2");

        //简单的重定向方法

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/responseDemo2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
