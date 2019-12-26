package cn.yzstu.baldwinblog.service.impl;

import cn.yzstu.baldwinblog.bean.User;
import cn.yzstu.baldwinblog.mapper.UserMapper;
import cn.yzstu.baldwinblog.service.UserService;
import cn.yzstu.common.Criteria;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/11
 * \* Time: 20:53
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ArrayList getList(Criteria criteria) {
        return userMapper.getList(criteria);
    }

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public int insert(User obj) {
        return userMapper.insert(obj);
    }

    @Override
    public int updateById(User obj) {
        return userMapper.updateById(obj);
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public JSONObject doLogin(Map<String, String> paramMap) {
        JSONObject retJson = new JSONObject();
        retJson.put("msg", null);
        retJson.put("viewName", "forward:/index.jsp");
        retJson.put("user", null);

        String email = paramMap.containsKey("email") ? paramMap.get("email") : "nothing";
        String password = paramMap.containsKey("password") ? paramMap.get("password") : "nothing";

        criteria.clear();
        criteria.put("email", email);
        ArrayList<User> users = getList(criteria);
        if (users.size() == 0) {
            retJson.put("retCode", "404");
            retJson.put("msg", "邮箱不存在，请检查邮箱后重新输入！");
            retJson.put("viewName", "forward:/login/index.jsp");
            return retJson;
        }

        User user = users.get(0);
        if (!password.equals(user.getUserPassword())) {
            retJson.put("retCode", "304");
            retJson.put("msg", "密码不正确，请检查密码后重新输入！");
            retJson.put("viewName", "forward:/login/index.jsp");
            return retJson;
        }

        retJson.put("user", user);

        return retJson;
    }

    @Override
    public JSONObject checkEmail(String userEmail) {
        JSONObject retJson = new JSONObject();
        criteria.clear();
        criteria.put("email", userEmail);
        ArrayList<User> users = getList(criteria);
        if (null != users) {
            retJson.put("retCode", "304");
            retJson.put("msg", "用户邮箱已存在，请检查邮箱后重新输入！");
            retJson.put("viewName", "forward:/login/register.jsp");
            return retJson;
        }

        return null;
    }
}