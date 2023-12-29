package com.cao.pms.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登陆拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功后，验证用户session
        Object loginUser = request.getSession().getAttribute("username");
        if(loginUser==null){
            request.setAttribute("msg","暂无权限，请先登录");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
