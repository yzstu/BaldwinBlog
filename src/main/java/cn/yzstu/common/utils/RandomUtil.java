package cn.yzstu.common.utils;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/16
 * \* Time: 17:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class RandomUtil {


    public static String getRandomString(int length) { //length表示生成字符串的长度
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}