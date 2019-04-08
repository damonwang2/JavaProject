package concurrence.philosopher;

public class Philosopher implements Runnable{
    private Chopstick left;
    private Chopstick right;
    private int index;
    private int thinkTime;

    public Philosopher(Chopstick left, Chopstick right, int index, int thinkTime) {
        this.left = left;
        this.right = right;
        this.index = index;
        this.thinkTime = thinkTime;
    }

    //sleep()方法让出CPU，不释放资源。
    private void thinking() throws InterruptedException{
        System.out.println(this + "thinking");
        Thread.sleep(thinkTime);
    }

    private void eating() throws InterruptedException{
        System.out.println(this + "eating");
        Thread.sleep(thinkTime);
    }

    @Override
    public void run() {
        try{
            while ( !Thread.interrupted() ){
                thinking();

                System.out.println(this + "take the left");
                left.take();
                System.out.println(this + "take the right");
                right.take();

                eating();

                left.drop();
                right.drop();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Philosopher [index = " + index + "]";
    }
}
