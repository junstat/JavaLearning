package com.jun.chap13_generic.section02.exer2;

import org.junit.Test;

import java.util.Arrays;

import static com.jun.chap13_generic.section02.exer2.Exercise.method1;
import static com.jun.chap13_generic.section02.exer2.Exercise.method2;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ExerciseTest {
    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "BB", "CC"};
        method1(arr, 0, 2);
        // System.out.println(Arrays.toString(arr));
        assertThat(arr.length, equalTo(3));
        assertThat(arr[0], equalTo("CC"));
        assertThat(arr[1], equalTo("BB"));
        assertThat(arr[2], equalTo("AA"));
    }

    @Test
    public void test2() {
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        method2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
