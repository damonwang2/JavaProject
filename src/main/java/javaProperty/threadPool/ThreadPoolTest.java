package javaProperty.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardPolicy() );

        for(int i=1;i<=16;i++){
            MyTask myTask = new MyTask(i);
            System.out.println("加入线程" + i);
            executor.execute(myTask);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize());
            System.out.println("队列中等待执行的任务数目："+ executor.getQueue().size());
            System.out.println("已执行完成的任务数目："+executor.getCompletedTaskCount());
            System.out.println();
        }

        executor.shutdown();
    }
}


class MyTask implements Runnable {
    private int taskNum;

    MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            System.out.println(taskNum + "睡眠开始" + df.format(System.currentTimeMillis()));
            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}