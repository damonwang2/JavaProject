package concurrence;

public class ThreadTest extends Thread {
    private int threadNo;

    public ThreadTest(int threadNo) {
        this.threadNo = threadNo;
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            new ThreadTest(i).start();
//            Thread.sleep(1);
        }
    }

    @Override
    public synchronized void run() {
        /*
        *对于一个成员方法加synchronized关键字，作用范围是调用run方法时，作用对象是该run方法所在的对象
        * 在本例中，就是 以ThreadTest类的一个具体对象，也就是该线程自身作为对象锁的
        * 一共十个线程，每个线程持有自己线程对象的那个对象锁。这必然不能产生同步的效果。
        * 换句话说，如果要对这些线程进行同步，那么这些线程所持有的对象锁应当是共享且唯一的！
         */
        for (int i = 0; i < 5; i++) {
            System.out.println("No." + threadNo + ":" + i);
        }
    }
}