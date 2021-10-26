package Chap02Adapter.objectMethod;

import Chap02Adapter.classMethod.Print;
import Chap02Adapter.classMethod.PrintBanner;

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
