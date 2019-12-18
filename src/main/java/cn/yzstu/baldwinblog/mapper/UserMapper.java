package cn.yzstu.baldwinblog.mapper;

import cn.yzstu.baldwinblog.bean.User;
import cn.yzstu.common.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

public interface UserMapper {
    int deleteById(Long userId);

    int insert(User record);

    User getById(Long userId);

    int updateById(User record);

    ArrayList getList(Criteria criteria);
}