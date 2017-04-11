package com.fy.commerce.config;

/**
 * Created by dell-pc on 2017/4/10.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@WebFilter(filterName="myFilter",urlPatterns="/**")
public class MyFilter implements Filter {

    @Value("${server.contextPath}")
    private String contextPath;

    @Override
    public void init(FilterConfig config) throws ServletException {
            System.out.println("过滤器初始化");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
            System.out.println("执行过滤操作");
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String uri = httpServletRequest.getRequestURI();

        if (uri.contains("static")){
            request.getRequestDispatcher(contextPath + uri).forward(httpServletRequest, response);
        }else {

            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
            System.out.println("过滤器销毁");
    }
}
