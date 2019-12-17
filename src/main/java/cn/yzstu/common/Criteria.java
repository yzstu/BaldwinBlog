package cn.yzstu.common;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/16
 * \* Time: 19:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Criteria {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 存放条件查询值
     */
    private Map<String, Object> condition;

    /**
     * 存放所要获取的字段的值，也可可以多为其他使用，灵活但注意安全！！！
     */
    private Map<String, Object> targetColums;

    /**
     * 存放查询时多个条件，便于遍历
     */
    private List<String> conditionList;

    /**
     * 是否相异
     */
    protected boolean distinct;

    /**
     * 排序字段
     */
    protected String orderByClause;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    protected Criteria(Criteria example) {
        this.orderByClause = example.orderByClause;
        this.condition = example.condition;
        this.distinct = example.distinct;
        this.mysqlLength = example.mysqlLength;
        this.mysqlOffset = example.mysqlOffset;
    }

    public Criteria() {
        condition = new HashMap<String, Object>();
        targetColums = new HashMap<String, Object>();
        conditionList = new ArrayList<String>();
    }

    public void clear() {
        condition.clear();
        orderByClause = null;
        distinct = false;
        this.mysqlOffset = null;
        this.mysqlLength = null;
    }

    /**
     * @param condition 查询的条件名称
     * @param value     查询的值
     */
    public Criteria put(String condition, Object value) {
        this.condition.put(condition, value);
        return (Criteria) this;
    }

    /**
     * @param targetColum 需要返回的列
     * @return
     */
    public Criteria putTarget(String targetColum) {
        this.targetColums.put(targetColum, targetColum);
        return (Criteria) this;
    }

    public Criteria setTargetColums(Map<String, Object> map) {
        this.targetColums = map;
        return (Criteria) this;
    }

    public List<String> getConditionList() {
        return conditionList;
    }

    public Criteria putConditionList(List<String> conditionList) {
        this.conditionList = conditionList;
        return (Criteria) this;
    }

    /**
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @param distinct 是否相异
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    /**
     * @param mysqlOffset 指定返回记录行的偏移量<br>
     *                    mysqlOffset= 5,mysqlLength=10;  // 检索记录行 6-15
     */
    public void setMysqlOffset(Integer mysqlOffset) {
        this.mysqlOffset = mysqlOffset;
    }

    /**
     * @param mysqlLength 指定返回记录行的最大数目<br>
     *                    mysqlOffset= 5,mysqlLength=10;  // 检索记录行 6-15
     */
    public void setMysqlLength(Integer mysqlLength) {
        this.mysqlLength = mysqlLength;
    }

    public Map<String, Object> getTargetColums() {
        return targetColums;
    }

    public void removeTargetColums(String key) {
        if (targetColums.containsKey(key)) {
            targetColums.remove(key);
        }
    }

    public void removeCondition(String key) {
        if (condition.containsKey(key)) {
            condition.remove(key);
        }
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        // 将对象写到流里
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 从流里读回来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}