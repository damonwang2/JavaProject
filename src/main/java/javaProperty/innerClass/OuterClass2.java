package javaProperty.innerClass;

public class OuterClass2 {
    private int i = 0;
    private static int j = 0;

    private static class InnerClass{
        static int k = 0;
        // 内部类可以访问外部类的静态变量和静态方法
        public void test(){
            j = 100;
            outerMethod2();
        }
    }

    public void outerMethod1() {
        InnerClass.k = 0;
    }

    public static void outerMethod2() {
        InnerClass.k = 0;
    }
}