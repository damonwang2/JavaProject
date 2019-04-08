package javaProperty.innerClass;

public class OuterClass4 {
    private int i = 0;

    public static void main(String[] args) {
        // 第一种方式
        A a = new A();
        Thread threadA = new Thread(a);
        threadA.start();

        // 第二种方式
        Runnable b = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread threadB = new Thread(b);
        threadB.start();

        // 答应b的类名
        System.out.println(b.getClass());

        // 第三种方式
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        threadC.start();
    }
}

class A implements Runnable {
    @Override
    public void run() {

    }
}
