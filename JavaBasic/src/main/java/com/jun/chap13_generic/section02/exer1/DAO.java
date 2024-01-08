package com.jun.chap13_generic.section02.exer1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
    Map<String, T> map;

    {
        map = new HashMap<>();
    }

    public void save(String id, T entity) {
        if (!map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
        return map.values().stream().toList();
    }

    public void delete(String id) {
        map.remove(id);
    }

}
