package cn.yzstu.baldwinblog.controller;

import cn.yzstu.baldwinblog.bean.User;
import cn.yzstu.baldwinblog.service.UserService;
import cn.yzstu.common.constants.Constants;
import cn.yzstu.common.utils.RandomUtil;
import cn.yzstu.common.utils.RequestUtil;
import cn.yzstu.common.utils.email.EmailUtil;
import cn.yzstu.common.utils.redis.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.SendFailedException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
@Api(value = "user相关接口", description = "user")
public class UserLoginController {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.action")
    @ApiOperation(value = "登录接口", notes = "进入登录界面", response = ModelAndView.class)
    ModelAndView userLogin(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();

        Map<String, String> paramMap = RequestUtil.getRequestParamMap(request);
        //减少controller中的代码，提高程序复用
        JSONObject retJSon = userService.doLogin(paramMap);

        HttpSession session = request.getSession();
        //session过期时间
        session.setMaxInactiveInterval(5 * 30);

        if (paramMap.get("remember") != null && paramMap.get("remember").equals("1"))
            session.setMaxInactiveInterval(-1);

        session.setAttribute("loginUser", retJSon.get("user"));
        request.setAttribute("msg", retJSon.get("msg"));
        mv.setViewName(retJSon.getString("viewName"));

        return mv;
    }

    /**
     * 跳转到登录界面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/regist.action")
    @ApiOperation(value = "注册接口", notes = "主要是用户信息收集", response = ModelAndView.class)
    public ModelAndView userRegist(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();

        String userEmail = request.getParameter("email");

        //6位随机验证码
        String emailVerifyCode = RandomUtil.getRandomString(6);
        //发送验证码
        try {
            EmailUtil.sendEmail(Constants.EMAIL_VERIFY_CONTANTS_PREFIX + emailVerifyCode + Constants.EMAIL_VERIFY_CONTANTS_SUFFIX, Constants.EMAIL_VERIFY_TITLE, userEmail);
        } catch (SendFailedException e) {//捕获错误的邮箱格式或其他原因导致的异常
            request.setAttribute("msg", "发送验证码失败，请检查邮箱格式或稍后重新发送！");
            mv.setViewName("forward:/login/register.jsp");
        }

        //String emailVerfyKey = userEmail ;
        //验证码存入redis，设置三分钟内过期，等待验证
        //打算把验证码设置成一天只能发一次，防止邮件攻击
        redisUtil.set(userEmail, emailVerifyCode, 180);

        //请求转发到验证界面
        request.setAttribute("msg", null);
        mv.setViewName("forward:/login/verify.jsp");
        return mv;
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "/emailVerify.action")
    @ApiOperation(value = "邮箱验证接口", notes = "验证用户邮箱", response = ModelAndView.class)
    public ModelAndView sendMail(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();

        Map<String, String> paramMap = RequestUtil.getRequestParamMap(request);

        String userMail = paramMap.containsKey("email") ? paramMap.get("email") : "nothing";
        String verifyCode = (String) redisUtil.get(userMail);
        if (null == verifyCode) {//验证码不存在===》失效
            request.setAttribute("msg", "验证码失效，请重新发送！");
            mv.setViewName("forward:/login/register.jsp");
            return mv;
        }

        String userCode = paramMap.get("emailVerify");
        if (!verifyCode.equalsIgnoreCase(userCode)) {
            request.setAttribute("msg", "验证码错误，请重新输入！");
            mv.setViewName("forward:/login/register.jsp");
            return mv;
        }

        User user = new User(paramMap);
        int target = userService.insert(user);

        request.setAttribute("msg", null);
        mv.setViewName("forward:/login/index.jsp");

        return mv;
    }


}