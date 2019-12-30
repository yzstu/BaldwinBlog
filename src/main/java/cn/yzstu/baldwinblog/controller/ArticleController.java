package cn.yzstu.baldwinblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/30
 * \* Time: 20:29
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @RequestMapping(value = "/editor.action")
    public ModelAndView editor(HttpServletRequest request) {

        return null;
    }
}