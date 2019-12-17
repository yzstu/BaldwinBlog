package cn.yzstu.baldwinblog.mapper;

import cn.yzstu.baldwinblog.bean.User;
import cn.yzstu.common.Criteria;

import java.util.ArrayList;

public interface UserMapper {
    int deleteById(Integer userId);

    int insert(User record);

    User selectById(Integer userId);

    int updateById(User record);

    ArrayList getList(Criteria criteria);
}