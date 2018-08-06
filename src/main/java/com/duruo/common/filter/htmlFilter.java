package com.duruo.common.filter;

import com.duruo.common.Const;
import com.duruo.po.User;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by @Author tachai
 * date 2018/8/6 14:29
 *
 * @Email 1206966083@qq.com
 */
//@Order(1)
//@WebFilter(urlPatterns = "/*",filterName = "htmlFilter")
public class htmlFilter implements Filter{
//    public FilterConfig config;

    public static boolean isContains(String container,String[] regx){
        boolean result = false;

        for (int i=0; i<regx.length;i++){
            if(container.indexOf(regx[i])!=-1){
                return true;
            }
        }
        return result;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //这里是得到webXML中的数字
//        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);

        //不做过滤的页面  文件上传的页面不做上传，工商信息查询的页面不做上传
        String[] loginList = {"/login.html","/success.html","/404.html","/500.html"};

        String redirectPath = hrequest.getContextPath()+"/login.html";//没有登录转向

        //对下面的不过滤
        if(this.isContains(hrequest.getRequestURI(),loginList)){
            filterChain.doFilter(request,response);
            return;
        }
        User user = (User) hrequest.getSession().getAttribute(Const.CURRENT_USER);//判断用户是否登录
        if(user == null){
            wrapper.sendRedirect(redirectPath);
            return;
        }else {
            filterChain.doFilter(request,response);
            return;
        }
    }

    @Override
    public void destroy() {
//        this.config = null;
    }
}
