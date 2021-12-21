package chap01;

import org.junit.Test;

public class Test01_OneDimensionArray {
    @Test
    public void test1() {
        // 1. 一维数组的声明和初始化
        int[] ids;  // 声明
        // 1.1 静态初始化: 数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1001, 1002, 1003, 1004};
        // 1.2 动态初始化: 数组的初始化和数组元素的赋值操作分开进行
        String[] names = new String[5];

        int[] arr4 = {1, 2, 3, 4, 5}; // 也是正确的，类型推断
        // 2. 访问指定下标的元素
        names[0] = "王铭";
        names[1] = "王赫";
        names[2] = "张学良";
        names[3] = "孙居龙";
        names[4] = "王宏志";

        // 3. 数组长度, length属性 arr.length
        System.out.println(names.length);

        // 4. 遍历数组
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

    @Test
    public void test2() {
        /*
          5. 数组的默认初始化
            整型: 0
            浮点型: 0.0
            char型: 0或'\u0000'
            boolean: false
            引用类型: null
        */
        int[] arr = new int[4];
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("**********");

        short[] arr1 = new short[4];
        for(int i = 0;i < arr1.length;i++){
            System.out.println(arr1[i]);
        }
        System.out.println("**********");
        float[] arr2 = new float[5];
        for(int i = 0;i < arr2.length;i++){
            System.out.println(arr2[i]);
        }

        System.out.println("**********");
        char[] arr3 = new char[4];
        for(int i = 0;i < arr3.length;i++){
            System.out.println("----" + arr3[i] + "****");
        }

        if(arr3[0] == 0){
            System.out.println("你好！");
        }

        System.out.println("**********");
        boolean[] arr4 = new boolean[5];
        System.out.println(arr4[0]);

        System.out.println("**********");
        String[] arr5 = new String[5];
        System.out.println(arr5[0]);
        if(arr5[0] == null){
            System.out.println("北京天气不错！");
        }
    }
}
