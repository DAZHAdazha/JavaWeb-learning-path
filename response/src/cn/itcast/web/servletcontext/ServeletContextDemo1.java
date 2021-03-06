package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/servletContextDemo1")
public class ServeletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServeletContext对象获取
        //1.拖过request对象获取
        ServletContext servletContext1 = request.getServletContext();

        //2.通过HttpServlet获取
        ServletContext servletContext2 = this.getServletContext();

        System.out.println(servletContext1);
        System.out.println("------------");
        System.out.println(servletContext2);

        System.out.println(servletContext1 == servletContext2);//true

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
