package blog.philosopher;

public class PhilosopherTest {
    public static void main(String[] args) {
        int size=5;
        Chopstick[] chopstick = new Chopstick[size];
        for(int i=0;i<size;i++){
            chopstick[i] = new Chopstick(i);
        }
        for(int i=0;i<size;i++){
            Thread thread = new Thread(new Philosopher(chopstick[(i+1)%size], chopstick[i], i));
            thread.start();
            //这里不能用join()方法，因为这会等待该进程结束了才会调用主进程，创造余下的进程
            //thread.join();
        }
        System.out.println("main线程已经结束");
    }
}
