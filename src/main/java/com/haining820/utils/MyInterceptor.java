package com.haining820.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    //在请求处理的方法之前执行
    //如果返回true执行下一个拦截器
    //如果返回false就不执行下一个拦截器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("------------MyInterceptor------------");
        System.out.println("当前URI: " + request.getRequestURI());

        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        String userName = (String) session.getAttribute("userName");
        String loginId = (String) session.getAttribute("loginId");
        System.out.println("当前session中的userType:" + userType);
        System.out.println("当前session中的userName:" + userName);
        System.out.println("当前session中的loginId:" + loginId);

        // if(request.getRequestURI().contains("login")||request.getRequestURI().contains("user")){
        //     return true;
        // }
        // if (userType != null) {  //对于 /user 下的请求,如果session中的userType不为空,则给予放行,否则拦截
        //     return true;
        // }
        // if(userName == null && userType == null){
        //     response.sendRedirect("/login.html");
        // }
        // request.getRequestDispatcher("/login.html").forward(request, response);
        return true;
    }

    //在请求处理方法执行之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在dispatcherServlet处理后执行,做清理工作
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("--------------------------");
    }
}
