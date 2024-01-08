package com.jun.chap13_generic.section02.exer1;

import org.junit.Test;

public class DAOTest {

    @Test
    public void test1() {
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(1, 33, "周杰伦"));
        dao.save("1002", new User(2, 23, "昆凌"));

        dao.update("1002", new User(3, 26, "蔡依林"));

        dao.delete("1002");

        dao.list().forEach(System.out::println);
    }
}
