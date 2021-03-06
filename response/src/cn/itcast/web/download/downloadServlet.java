package cn.itcast.web.download;

import cn.itcast.web.utils.DownloadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/image/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型 content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setContentType(mimeType);

        //解决中文文件名问题
        //1.获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownloadUtils.getFileName(agent,filename);

        //3.2设置响应头打开方式content-disposition
        response.setHeader("content-disposition","attachment;filename=" + filename);//filename的值为提示框中出现的值

        //4.将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            outputStream.write(buff,0,len);
        }
        fis.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
