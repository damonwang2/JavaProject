package javaProperty;

public class ThreadLocalTest {
    public static void main (String[] args) {
        ThreadLocal<String> threadLocalA = new ThreadLocal();
        ThreadLocal<Integer> threadLocalB = new ThreadLocal();

        Thread thread1 = new Thread(new MyThread1("线程1", threadLocalA, threadLocalB));

        Thread thread2 = new Thread(new MyThread2("线程1", threadLocalA, threadLocalB));

        thread1.start();


        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }

        thread2.start();



    }
}

class MyThread1 extends Thread{
    ThreadLocal<String> threadLocalA;
    ThreadLocal<Integer> threadLocalB;
    ThreadLocal<String> threadLocalC;
    public MyThread1(ThreadLocal C){
        this.threadLocalC=C;
    }
    public MyThread1(String name, ThreadLocal threadLocalA, ThreadLocal threadLocalB){
        super(name);
        this.threadLocalA = threadLocalA;
        this.threadLocalB = threadLocalB;
    }
    @Override
    public void run(){
        threadLocalA.set("1234");
//        threadLocalB.set(30);
        System.out.println("thread1 set threadLocalA " + threadLocalA.get());
    }
}

class MyThread2 extends Thread{
    ThreadLocal<String> threadLocalA;
    ThreadLocal<Integer> threadLocalB;

    ThreadLocal<String> threadLocalC;
    public MyThread2(ThreadLocal C){
        this.threadLocalC=C;
    }

    public MyThread2(String name, ThreadLocal threadLocalA, ThreadLocal threadLocalB){
        super(name);
        this.threadLocalA = threadLocalA;
        this.threadLocalB = threadLocalB;
    }
    @Override
    public void run(){
        System.out.println("thread2 get threadLocalA:" + threadLocalA.get());
        threadLocalA.set("5678");
//        threadLocalB.set(40);
    }
}