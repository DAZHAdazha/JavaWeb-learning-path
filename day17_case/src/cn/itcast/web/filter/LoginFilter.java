package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest req = (HttpServletRequest) request;
        //1.获取资源的请求路径
        String requestURI = req.getRequestURI();
        //2.判断是否包含登录相关资源路径,要注意排除掉css/js/图片/验证码等资源
        if(requestURI.contains("/login.jsp") ||
                requestURI.contains("loginServlet") ||
                requestURI.contains("/css/") ||
                requestURI.contains("/js/") ||
                requestURI.contains("/fonts/") ||
                requestURI.contains("/checkCodeServlet") ||
                requestURI.contains("/testServlet")
        ){
            //包含，用户就是想登录
            chain.doFilter(request, response);
        } else {
            //不包含，验证用户是否登录
            //3.从session中获取user
            Object user = req.getSession().getAttribute("user");
            if(user != null){
                //登录了，放行
                chain.doFilter(request, response);
            } else {
                //没有登录,跳转到登录页面
                req.setAttribute("login_msg","您尚未登录，请登录");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
            }
        }

        chain.doFilter(request, response);
    }
}
