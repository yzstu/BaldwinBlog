package cn.yzstu.baldwinblog.filter;

import cn.yzstu.baldwinblog.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/18
 * \* Time: 14:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    Logger loggerFactory = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String basePath = request.getContextPath();
        String path = request.getRequestURI();

        loggerFactory.info("basePath:" + basePath);
        loggerFactory.info("path:" + path);

        //如果登录了，会把用户信息存进session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {

            loggerFactory.info("登录超时或尚未登录，跳转到登录界面");
            response.sendRedirect(request.getContextPath() + "/login/index.jsp");
            return false;
        }
        loggerFactory.info("用户已登录,userName:" + user.getUserName());
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}