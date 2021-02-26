package cn.itcast.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/RequestDemo8")
public class RequestDemo8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8");

        //存储数据到request域中
        request.setAttribute("msg","hello");

        //转发到demo9资源
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RequestDemo9");
//        requestDispatcher.forward(request,response);
//        上面可以简写为
        request.getRequestDispatcher("/RequestDemo9").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post 获取请求参数
        //根据参数名称获取参数值
//        String username = request.getParameter("username");
//        System.out.println("post");
//        System.out.println(username);
        //简化代码
        this.doGet(request,response);
    }
}
