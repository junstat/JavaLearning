package com.jun.chap13_generic.section02.exer1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private int age;
    private String name;
}
