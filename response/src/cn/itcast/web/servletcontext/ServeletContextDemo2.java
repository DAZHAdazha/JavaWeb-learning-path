package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/servletContextDemo2")
public class ServeletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServeletContext对象功能
        //1.通过HttpServlet获取
        ServletContext servletContext = this.getServletContext();

        //2.定义文件名称
        String filname = "a.jpg";

        //3.获取MIME类型
        String mimeType = servletContext.getMimeType(filname);
        System.out.println(mimeType); //image/jpeg
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
