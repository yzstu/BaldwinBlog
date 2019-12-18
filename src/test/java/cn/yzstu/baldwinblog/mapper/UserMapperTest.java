package cn.yzstu.baldwinblog.mapper;

import cn.yzstu.baldwinblog.bean.User;
import cn.yzstu.baldwinblog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @描述
 * @Author Baldwin
 * @E-Mail DikeyWang@163.com || baldwin@chancellorhk.com
 * @Time 2019/12/18 14:24
 * @Other
 */
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void getById() {
        User user = userMapper.getById(Integer.toUnsignedLong(10001));
        System.out.println(user.toString());
    }

    @Test
    public void updateById() {
    }

    @Test
    public void getList() {
    }
}