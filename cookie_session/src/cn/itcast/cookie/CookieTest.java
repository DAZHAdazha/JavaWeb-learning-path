package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取所有cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                //判断是否是lastTime
                if("lastTime".equals(name)){
                    //有该cookie，不是第一次访问

                    //设置cookies的value
                    Date date = new Date();
                    //注意空格等特殊字符需要URL编码！！！
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    //URL编码
                    str_date = URLEncoder.encode(str_date,"utf-8");

                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24*30);//一个月
                    response.addCookie(cookie);

                    //相应数据
                    //获取cookie的value
                    String value = cookie.getValue();

                    //URL解码
                    value = URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来,上次访问时间为：" + value + "<h1>");

                    flag = true;
                    break;
                }
            }
        }

        if(cookies == null || cookies.length==0 || flag == false){
            //设置cookies的value
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            //URL编码
            str_date = URLEncoder.encode(str_date,"utf-8");
            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setValue(str_date);
            cookie.setMaxAge(60*60*24*30);//一个月
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎首次登录<h1>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
