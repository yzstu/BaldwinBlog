package cn.yzstu.baldwinblog.controller;

import cn.yzstu.baldwinblog.bean.User;
import cn.yzstu.baldwinblog.service.UserService;
import cn.yzstu.common.utils.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/11
 * \* Time: 20:55
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/login.action")
    String userLogin(){
        String str = null;
        User user = userService.getbyId(1);
        str = user.toString();


        String key = user.getUserName()+user.getUserId()+"loginNum";

        if (redisUtil.hasKey(key)) {
            redisUtil.incr(key, 1);
        } else {
            redisUtil.set(key,1,20);
        }

        return "index";
        //return user.getUserName()+"登陆了"+redisUtil.get(key)+"次";
    }
}