package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


@WebServlet("/servletContextDemo5")
public class ServeletContextDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServeletContext对象功能
        //1.通过HttpServlet获取
        ServletContext servletContext = this.getServletContext();

        //2.获取文件的服务器真实路径
        String realPath = servletContext.getRealPath("/b.txt");//web目录下资源访问
        String realPath2 = servletContext.getRealPath("/WEB-INF/c.txt");//WEB_INF目录下资源访问
        String realPath3 = servletContext.getRealPath("/WEB-INF/classes/a.txt");//src目录下资源会被自动放到WEB-INF下classes目录下
        System.out.println(realPath);
        System.out.println(realPath2);
        System.out.println(realPath3);
        File file = new File(realPath);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
