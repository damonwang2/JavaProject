package concurrence;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CalculateTask task = new CalculateTask();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
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
        return sum;
    }
}
