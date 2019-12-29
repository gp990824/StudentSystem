package com.gp.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author gp
 * @create 2019/12/23 17:24
 */
public class AccessController implements Filter {
    String Encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init....");
        this.Encoding = filterConfig.getInitParameter("Encoding");
        System.out.println("Encoding:"+Encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //获取根目录所对应的绝对路径
        String requestURI = request.getRequestURI();
        //截取文件名,用于比较

        String substring = requestURI.substring(requestURI.indexOf("/"),requestURI.length());

        HttpSession session = request.getSession(false);

        String contextPath = request.getContextPath();
        //判断当前页是否是登录页面,如果不是就跳转到登录页面
        if (!"/StudentSystem/".equals(substring)) {
            if (session == null || session.getAttribute("name") == null) {
                response.sendRedirect(contextPath);
                return;
            }
        }

        //如果session已存在用户的登录信息,就放行,程序继续往下执行
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

        System.out.println("Filter is destroyed!!!!");
    }
}
