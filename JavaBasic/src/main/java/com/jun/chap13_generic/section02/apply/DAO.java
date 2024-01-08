package com.jun.chap13_generic.section02.apply;

import java.util.List;

public class DAO<T> {
    // 增
    public void insert(T bean) {

    }

    // 删
    public T deleteById(int id) {
        return null;
    }

    // 改
    public void update(int id, T bean) {
        // 略
    }

    // 查
    public T queryForInstance(int id) {
        // 略
        return null;
    }

    public List<T> queryForList(int id) {
        return null;
    }

    // 定义泛型方法
    // 如: 查询表中的最大记录数。(E: Long类型)
    // 如: 查询表中最大生日。(E: Date类型)
    public <E> E getValue(String sql) {
        return null;
    }
}
