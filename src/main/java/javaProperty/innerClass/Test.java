package javaProperty.innerClass;

public class Test {
    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
    }

    public void test() {
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
    }
}
