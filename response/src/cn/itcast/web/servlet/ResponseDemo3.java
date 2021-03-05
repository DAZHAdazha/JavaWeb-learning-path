package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码：将ISO-8859-1改为utf-8
//        response.setCharacterEncoding("utf-8");

        //告诉服务器，服务器发送消息体数据的编码，建议服务器使用该编码解码，使用了这一行代码可以省略上一行
//        response.setHeader("content-type","text/html;charset=utf-8");

        //上面一行代码的简单的形式来设置编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据,文字或者输入html，浏览器会自动解析大三
        pw.write("<h1>hello response<h1>");
        pw.write("你好");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
