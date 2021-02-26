package cn.itcast.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式： GET
        String method = request.getMethod();
        System.out.println(method);

        //2.获取虚拟目录：/day14  (在tomcat中设置的映射目录)
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        //3.获取Servlet路径： /RequestDemo1 (装饰器中填的资源路径)
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //4.获取get请求参数： name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //5.获取请求URI: /day14/RequestDemo1
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);

        //6.获取协议版本： HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //7.获取客户机IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
