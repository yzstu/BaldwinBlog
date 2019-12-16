package cn.yzstu.baldwinblog.service.baseinterface;

import cn.yzstu.common.Criteria;

import java.util.ArrayList;

/**
 * @描述
 * @Author Baldwin
 * @E-Mail DikeyWang@163.com || baldwin@chancellorhk.com
 * @Time 2019/12/16 18:56
 * @Other
 */
public interface DataBaseService<O> {

    ArrayList<O> getList(Criteria criteria);

    O getById(Integer id);

    int insert(O obj);

    int updateById(O obj);

    int deleteById(Integer id);
}
