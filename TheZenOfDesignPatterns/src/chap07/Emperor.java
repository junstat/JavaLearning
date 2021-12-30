package chap07;

public class Emperor {
    private static final Emperor empror = new Emperor();    // 初始化一个皇帝

    private Emperor() {
        // 世俗和道德约束你，目的就是不希望产生第二个皇帝
    }

    public static Emperor getInstance() {
        return empror;
    }

    // 皇帝发话了
    public static void say() {
        System.out.println("我就是皇帝某某某....");
    }
}
