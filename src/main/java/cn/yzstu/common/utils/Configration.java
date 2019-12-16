package cn.yzstu.common.utils;

import java.util.ResourceBundle;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/16
 * \* Time: 16:28
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Configration {
    private static Object lock = new Object();
    private static Configration config = null;
    private static ResourceBundle rb = null;

    private Configration(String filename) {
        rb = ResourceBundle.getBundle(filename);
    }


    public static Configration getInstance(String filename) {
        synchronized (lock) {
            if (null == config) {
                config = new Configration(filename);
            }
        }
        return (config);
    }

    public String getValue(String key) {
        String ret = "";
        if (rb.containsKey(key)) {
            ret = rb.getString(key);
        }
        return ret;
    }
}
