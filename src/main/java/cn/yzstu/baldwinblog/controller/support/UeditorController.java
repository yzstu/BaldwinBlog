package cn.yzstu.baldwinblog.controller.support;

import cn.yzstu.baldwinblog.bean.Ueditor;
import cn.yzstu.baldwinblog.bean.msg.PublicMsg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2020/1/2
 * \* Time: 20:31
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RequestMapping(value = "/ueditor")
public class UeditorController {

    @RequestMapping(value = "/ueditor.action")
    @ResponseBody
    public String ueditor(HttpServletRequest request) {

        return PublicMsg.UEDITOR_CONFIG;
    }

    @RequestMapping(value = "/imgUpload")
    @ResponseBody
    public Ueditor imgUpload(MultipartFile upfile) {
        Ueditor ueditor = new Ueditor();
        return ueditor;
    }
}