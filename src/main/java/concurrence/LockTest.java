package concurrence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest{
    public static void main(String[] args) {
        SellTicketsRunnable str = new SellTicketsRunnable();

        //三个线程用的同一个对象，即同一个票源
        Thread tr1 = new Thread(str, "窗口1");
        Thread tr2 = new Thread(str, "窗口2");
        Thread tr3 = new Thread(str, "窗口3");

        tr1.start();
        tr2.start();
        tr3.start();
    }
}

class SellTicketsRunnable implements Runnable{
    // 定义票
    private int tickets = 100;

    // 定义锁对象,这是实例对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 加锁
//                lock()方法会对Lock实例对象进行加锁，因此所有对该对象调用lock()方法的线程都会被阻塞，直到该Lock对象的unlock()方法被调用。
                lock.lock();
                if (tickets > 0) {
                    try {
                        //线程已经占有锁，如果不睡眠，则会一直拥有锁
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                }else {
                    //退出售票系统
                    break;
                }
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }

}