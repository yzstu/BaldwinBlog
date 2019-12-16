package cn.yzstu.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, String[]> getRequestParamMap(HttpServletRequest request) {
        Map<String, String[]> hashMap = new HashMap<>();
        hashMap = request.getParameterMap();
        return hashMap;
    }
}