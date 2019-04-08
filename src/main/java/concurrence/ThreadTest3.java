package concurrence;

public class ThreadTest3 extends Thread{

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            (new ThreadTest3(i)).start();
            //Thread.sleep可能抛出异常需要处理
            try {
                Thread.sleep(10);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    private int threadNo;
    private String lock;

    //构造函数
    public ThreadTest3(int threadNo){
        this.threadNo = threadNo;
    }

    //重写run方法
    public void run(){
        f(threadNo);
    }

    //synchronized修饰静态方法
    //其作用的范围是整个静态方法，作用的对象是这个类的所有对象
    public static synchronized void f(int threadNo){
        for(int i = 0; i < 5; i++){
            System.out.println("No." + threadNo + ":" + i);
        }
    }

}



