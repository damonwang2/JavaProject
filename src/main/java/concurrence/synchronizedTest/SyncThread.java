package concurrence.synchronizedTest;

class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public void run() {
        synchronized(this) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
            }
        }
    }
}
