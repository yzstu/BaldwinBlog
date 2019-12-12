package cn.yzstu.baldwinblog.mapper;

import cn.yzstu.baldwinblog.bean.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper {
    int deleteById(Integer userId);

    int insert(User record);

    User selectById(Integer userId);

    int updateById(User record);
}