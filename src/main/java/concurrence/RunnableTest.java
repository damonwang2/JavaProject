package concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new CalculateRunnableTask());
    }
}

class CalculateRunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("子线程在进行计算");
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
    }
}
