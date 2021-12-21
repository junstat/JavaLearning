package Chap03TemplateMethod;

public class Main {
    public static void main(String[] args) {
        CharDisplay d1 = new CharDisplay('H');
        StringDisplay d2 = new StringDisplay("Hello, World.");
        StringDisplay d3 = new StringDisplay("你好，世界");

        d1.display();
        d2.display();
        d3.display();
    }
}
