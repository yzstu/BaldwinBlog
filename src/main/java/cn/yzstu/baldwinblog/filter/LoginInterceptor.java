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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        //如果neverIntercept，那就直接进行下一个
        if (neverIntercept(basePath, path)) {
            return true;
        }

        //如果登录了，会把用户信息存进session
        HttpSession session = request.getSession();
        List<User> users = (List<User>) session.getAttribute("userList");

        if (users == null) {

            /*response.sendRedirect(request.getContextPath()+"signin");*/
            String requestType = request.getHeader("X-Requested-With");
            if (requestType != null && requestType.equals("XMLHttpRequest")) {
                response.setHeader("sessionstatus", "timeout");
                response.getWriter().print("LoginTimeout");
            } else {
                loggerFactory.info("尚未登录，跳转到登录界面");
                response.sendRedirect(request.getContextPath() + "login.action");
            }
            return false;
        }
        //      log.info("用户已登录,userName:"+userInfo.getSysUser().getUserName());
        return true;
    }

    private boolean neverIntercept(String basePath, String path) {
        //获取请求URI
        path = path.substring(basePath.length());
        Set<String> neverInterCeptPathSet = new HashSet<>();
        neverInterCeptPathSet.add("/css/");
        neverInterCeptPathSet.add("/font/");
        neverInterCeptPathSet.add("/font-awesome/");
        neverInterCeptPathSet.add("/image/");
        neverInterCeptPathSet.add("/js/");
        neverInterCeptPathSet.add("/layui/");
        neverInterCeptPathSet.add("/error");
        neverInterCeptPathSet.add("/login/");

        for (String begin : neverInterCeptPathSet) {
            if (path.startsWith(begin)) return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        if (null == user) modelAndView.setViewName("forward:/login/index.jsp");
    }
}