package com.baiyi.behavior.responsibilitychain;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 自定义过滤器 学习 tomcat 责任链
 * @author: BaiYi
 * @date: 2022/10/20 21:27
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 前置逻辑
        filterChain.doFilter(servletRequest, servletResponse);
        // 后置过滤
    }

    @Override
    public void destroy() {

    }
}
