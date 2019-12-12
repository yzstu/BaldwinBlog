package cn.yzstu.baldwinblog.service.impl;

import cn.yzstu.baldwinblog.bean.User;
import cn.yzstu.baldwinblog.mapper.UserMapper;
import cn.yzstu.baldwinblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User getbyId(int id) {
        return userMapper.selectById(Integer.valueOf(id));
    }
}