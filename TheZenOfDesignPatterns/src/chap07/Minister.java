package chap07;

public class Minister {
    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            System.out.println(emperor);
            emperor.say();
        }
        // 三天记的皇帝都是同一个人
    }
}
