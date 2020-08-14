package concurrence;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //第一种方式：Executor
        ExecutorService executor = Executors.newCachedThreadPool();
        CalculateTask task = new CalculateTask();
        //把task包装到FutureTask中
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Future<String> result = executor.submit(futureTask, "test");
        System.out.println(result.get() + "" + System.currentTimeMillis());
        executor.shutdown();

        //第二种方式：Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕:" + System.currentTimeMillis());
    }
}