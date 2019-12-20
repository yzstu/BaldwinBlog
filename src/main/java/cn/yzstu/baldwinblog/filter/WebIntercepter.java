package cn.yzstu.baldwinblog.filter;

import cn.yzstu.baldwinblog.bean.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/20
 * \* Time: 16:37
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class WebIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if (null == user) {
            response.sendRedirect(request.getContextPath() + "/login/index.jsp");
            return false;
        }
        return true;
    }
}