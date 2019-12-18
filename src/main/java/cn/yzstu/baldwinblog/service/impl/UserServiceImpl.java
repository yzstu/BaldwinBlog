package cn.yzstu.baldwinblog.service.impl;

import cn.yzstu.baldwinblog.bean.User;
import cn.yzstu.baldwinblog.mapper.UserMapper;
import cn.yzstu.baldwinblog.service.UserService;
import cn.yzstu.common.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}