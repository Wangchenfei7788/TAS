package com.wcf.tas.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",
           urlPatterns = {"/*"},
           initParams = {@WebInitParam(name = "encoding",value = "UTF-8")},
           dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE}
          )
public class CharacterEncodingFilter implements Filter {
    protected String encoding = null;
    protected FilterConfig cfg = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.cfg=filterConfig;
        this.encoding=cfg.getInitParameter("encoding");
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        this.cfg=null;
        this.encoding=null;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest reg = (HttpServletRequest)servletRequest;
        String contextPath = reg.getContextPath();
        String regURL = "";
        if (contextPath.equals("/")){
            regURL =reg.getRequestURI();
        }else {
            regURL =reg.getRequestURI().substring(contextPath.length());
        }
        String srcURL =regURL.toLowerCase();
        if (srcURL.endsWith(".jpg") || srcURL.endsWith(".png") || srcURL.endsWith(".html") || srcURL.endsWith(".gif")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if(encoding!=null){
            reg.setCharacterEncoding(encoding);
            servletResponse.setContentType("text/html;charset=UTF-8");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
