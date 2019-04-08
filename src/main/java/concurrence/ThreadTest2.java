package concurrence;

public class ThreadTest2 extends Thread {
    private int threadNo;
    private String lock;

    public ThreadTest2(int threadNo, String lock) {
        this.threadNo = threadNo;
        this.lock = lock;
    }

    public static void main(String[] args) throws Exception {
        String lock = new String("lock");
        for (int i = 1; i < 5; i++) {
            //第一个线程锁住了lock，不能创建第二个线程。
            new ThreadTest2(i, lock).start();
            Thread.sleep(1);
        }
    }
    public void run() {
        // 在输出的期间lock只能一个线程访问
        // 这些线程所持有的对象锁应当是共享且唯一的！
        synchronized (lock) {
            for (int i = 1; i < 5; i++) {
                System.out.println("No." + threadNo + ":" + i);
            }
        }
    }
}
