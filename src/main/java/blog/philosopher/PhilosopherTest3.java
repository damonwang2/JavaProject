package blog.philosopher;

public class PhilosopherTest3 {
    public static void main(String[] args) {
        int size=5;
        int thinkTime= 10;
        int eatTime = 10;
        Chopstick[] chopstick = new Chopstick[size];
        for(int i=0;i<size;i++){
            chopstick[i] = new Chopstick(i);
        }
        for(int i=0;i<size;i++){
            Thread thread = new Thread(new Philosopher3(chopstick[(i+1)%size], chopstick[i], i));
            thread.start();
        }

        //提供一个服务生

        System.out.println("main线程已经结束");
    }
}
