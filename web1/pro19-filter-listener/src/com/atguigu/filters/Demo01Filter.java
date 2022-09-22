package com.atguigu.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
//@WebFilter("/*.do")
public class Demo01Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("A");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("A2");

    }

    @Override
    public void destroy() {

    }
}
