package cn.itcast.web.servlet;
//Servlet注解
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//3种写法配置
//@WebServlet(urlPatterns = "/demo3")
//@WebServlet(value = "/demo3")
@WebServlet("/demo3")
public class ServletDemo3 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service Annotation");
    }


    @Override
    public String getServletInfo() {
        return null;
    }


    @Override
    public void destroy() {
        System.out.println("destory...");
    }
}
