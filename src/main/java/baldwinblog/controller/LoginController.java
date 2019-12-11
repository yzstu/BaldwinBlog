package baldwinblog.controller;

import baldwinblog.bean.User;
import baldwinblog.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

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
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.action")
    String userLogin(){
        String str;
        User user = userService.getbyId(1);
        str = user.toString();
        return str;
    }
}