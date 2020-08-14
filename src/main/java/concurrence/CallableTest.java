package concurrence;

import java.util.concurrent.*;

public class CallableTest {

    static CompletableFuture<String> completableFuture = new CompletableFuture<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CalculateTask task = new CalculateTask();
        Future<Integer> future = executor.submit(task);
        executor.shutdown();
        //String completeFutureResult = CompletableFuture.runAsync();
        //System.out.println(completeFutureResult);
        try {
            System.out.println("task运行结果" + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}

class CalculateTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;

        CallableTest.completableFuture.complete("complete");
        return sum;
    }
}
