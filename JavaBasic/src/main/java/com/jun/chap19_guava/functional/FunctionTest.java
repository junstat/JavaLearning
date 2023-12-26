package com.jun.chap19_guava.functional;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                Preconditions.checkNotNull(input, "The input Stream should not be null.");
                return input.length();
            }
        };
        System.out.println(function.apply("Hello"));
    }
}
