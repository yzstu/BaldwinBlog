package cn.yzstu.common.utils;

import cn.yzstu.baldwinblog.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static cn.yzstu.common.constants.Content.SESSION_LOGIN_USER;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/16
 * \* Time: 17:24
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class RequestUtil {

    public static Map<String, String[]> getRequestParamsMap(HttpServletRequest request) {

        Map<String, String[]> hashMap = new HashMap<>(request.getParameterMap());
        String[] ip = {getIp(request)};
        hashMap.put("ip", ip);
        return hashMap;
    }

    public static Map<String, String> getRequestParamMap(HttpServletRequest request) {

        Map<String, String[]> hashMap = getRequestParamsMap(request);
        Map<String, String> retMap = new HashMap<>();
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            retMap.put(key, hashMap.get(key)[0]);
        }
        return retMap;
    }

    private static String getIp(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static User getSessionLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (null == session) {
            return null;
        }
        User user = (User) session.getAttribute(SESSION_LOGIN_USER);
        return user;
    }
}