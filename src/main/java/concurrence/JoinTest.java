package concurrence;

public class JoinTest{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始");
        MyThread thread1 = new MyThread("A");
        MyThread thread2 = new MyThread("B");
        thread1.start();
        try{
            //在main线程中调用thread1.join()方法，意味着等待thread1结束才能继续运行
            thread1.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        thread2.start();

        try{
            // 所以线程A运行在线程B前
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "主线程运行结束");
    }
}

class MyThread extends Thread{

    private String name;
    //重写构造方法

    public MyThread(){

    }

    public MyThread(String name){
        //super必须放在第一行，首先执行
        super(name);
        this.name = name;
    }
    //覆盖run方法
    public void run(){
        System.out.println(Thread.currentThread().getName() + "线程运行开始");
        for(int i = 0; i < 5; i++){
            System.out.println("Thread " + name + " run:" + i);
        }
        System.out.println(Thread.currentThread().getName() + "线程运行结束");
    }
}