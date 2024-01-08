package com.jun.chap13_generic.section02.exer3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student<T> {
    private String name;
    private T score;
}
