package javaProperty.innerClass;

public class OuterClass3 {
    private int i = 0;
    private int j = 0;

    public void test() {
        int i = 0;
        class InnerClass {
            public InnerClass() {

            }
            public void innerTest() {
                System.out.println(i);
                // 访问外部类的非静态变量
                System.out.println(OuterClass3.this.i);

                System.out.println(j);
            }
        }
    }
}