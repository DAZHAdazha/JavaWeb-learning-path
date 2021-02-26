package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据:referer
        String referer = request.getHeader("referer");
        System.out.println(referer); //如果是null则是浏览器输入地址访问的

        //防盗链
        if (referer != null){
            if(referer.contains("/myWebsite")){
                //正常访问
                System.out.println("welcome");
            }else{
                //盗链
                System.out.println("Sorry, you should visit myWebsite");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
