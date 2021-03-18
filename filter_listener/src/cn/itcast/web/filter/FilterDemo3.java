package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 在服务器启动后，会创建Filter对象，然后调用init方法，只执行一次,用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 在服务器关闭后，Filter对象会被销毁。如果服务器是正常关闭，则会使用destroy，只执行一次，用于释放资源
     */
    public void destroy() {
        System.out.println("destroy...");
    }

    /**
     * 每一次请求被拦截资源时会执行，可以执行多次
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("do filter...");
        chain.doFilter(request, response);
    }
}
