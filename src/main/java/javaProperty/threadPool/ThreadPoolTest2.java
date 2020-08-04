package javaProperty.threadPool;

import java.util.concurrent.*;

public class ThreadPoolTest2 {
    public static void main(String[] args) {

        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                10, 10, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        threadPool.submit(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(threadPool.getLargestPoolSize());

        System.out.println(threadPool.getActiveCount());

        MyThread myThread = new MyThread();
        System.out.println(myThread.isAlive());

        Thread thread = new Thread(() -> System.out.println("hello"));
        System.out.println(thread.isAlive());
    }

    public static class MyThread extends Thread {
        public MyThread() {
            super();
            super.start();
        }
    }

    public static class MyThreadLocal<T> extends ThreadLocal<T> {
        @Override
        protected T initialValue() {
            return null;
        }
    }

}