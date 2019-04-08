package javaProperty.innerClass;

public class OuterClassSub extends OuterClass{
    public static void main(String[] args) {
        InnerClass innerClass = new OuterClass().new InnerClass();
    }

    // 子类的非static方法可以直接new
    // 成员内部类也是成员，会被子类继承
    public void test() {
        InnerClass innerClass = new InnerClass();
    }
}
