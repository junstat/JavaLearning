package chap02;

import org.junit.Test;

public class WrapperTest {
    // 基本数据类型 -> 包装类: 调用包装类的构造器
    @Test
    public void test1() {
        int num1 = 10;
        Integer in1 = new Integer(num1);
        Integer in2 = new Integer("123");

        // 报错 java.lang.NumberFormatException: For input string: "123abc"
        // Integer in3 = new Integer("123abc");
        // System.out.println(in3);
    }
}
