package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie c1 = new Cookie("msg", "setMaxAge");
        //2.设置cookie存活时间
        c1.setMaxAge(30);//将cookie持久化存储到硬盘，30s后会自动删除cookie文件
//        c1.setMaxAge(-1);//默认值 关闭浏览器即删除文件
//        c1.setMaxAge(0);//将cookie删除
        //3.发送cookie
        response.addCookie(c1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
