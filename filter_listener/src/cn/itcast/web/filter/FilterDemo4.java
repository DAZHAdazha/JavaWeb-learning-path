package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/index.jsp")
//@WebFilter("/user/*")
//@WebFilter("*.jsp")//注意前面没有"/"
public class FilterDemo4 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4...");
        chain.doFilter(request, response);
    }
}
