package javaProperty.innerClass;

public class OuterClass {
    private int i = 0;
    private static int j = 0;

    public class InnerClass{
        int k = 0;
        // 内部类可以访问外部类的成员变量和静态变量
        public void test(){
            i = 100;
            j = 100;
            outerMethod1();
            outerMethod2();
        }
    }

    public void outerMethod1() {
        InnerClass innerClass = new InnerClass();
        System.out.println(innerClass.k);
        innerClass.test();
    }

    public static void outerMethod2() {
    }
}