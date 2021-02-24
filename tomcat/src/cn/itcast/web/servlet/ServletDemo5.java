package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet路径配置
 */
//@WebServlet({"/d5","/dd5","/demo5"})
//两层路径
//@WebServlet("/user/demo5")
    // 任意匹配,这种全部匹配的优先级很低，只有其他都无法匹配才会最后匹配这个
//@WebServlet("*")
//@WebServlet("/user/*")
    //注意这里前面不要加"/","com"表示后缀
@WebServlet("*.com")


public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("domo5...");
    }

}
