package concurrence;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    public static int count = 0;
    public static AtomicInteger count2 = new AtomicInteger(0);

    public static void main(String[] args) {
        for(int i = 0; i < 2; i++){
            //Thread接受一个实现了Runnable接口的匿名类的匿名对象
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    for(int j = 0; j < 100; j++){
                        count2.incrementAndGet();
                        synchronized (CASTest.class){
                            count++;
                        }
                    }
                }
            }).start();
        }

        //main线程睡眠1秒钟，保证之前的线程执行完毕
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("count = " + count);
        System.out.println("count2 = " + count2);
    }
}
