package concurrence;

public class ConcurrentlyCalTest extends Thread {

    public static void main(String[] args) throws Exception {

        int count = 0;
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 10; i++) {
                new Thread(new Thread1(i)).start();
            }

            Thread.sleep(1000);
            // 记录count更大的
            if (Thread1.countDouble > Thread1.count) {
                count++;
            }
        }
        System.out.println("整数更大的次数:" + count);
    }

    /**
     * 分离线程对象和运行的对象
     */
    private static class Thread1 implements Runnable {

        private static int count;

        private static double countDouble;

        private int threadNo;

        private Thread1(int threadNo) {
            this.threadNo = threadNo;
        }

        /**
         * 对于一个成员方法加synchronized关键字，作用范围是调用run方法时，作用对象是该run方法所在的对象，即this对象
         * 一共十个线程，每个线程持有自己线程对象的那个对象锁。这必然不能产生同步的效果。
         * 换句话说，如果要对这些线程进行同步，那么这些线程所持有的对象锁应当是共享且唯一的！
         * 比如使用static成员
         */
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                count = count + 1;
            }

            for (int i = 0; i < 10000; i++) {
                countDouble = countDouble + 1.00D;
            }
            //System.out.println("finish " + threadNo);
        }
    }
}