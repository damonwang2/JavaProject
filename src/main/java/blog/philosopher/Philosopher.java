package blog.philosopher;

public class Philosopher implements Runnable{
    protected Chopstick left;
    protected Chopstick right;
    protected int index;
    protected int thinkTime;
    protected int eatTime;

    public Philosopher(Chopstick left, Chopstick right, int index) {
        this.left = left;
        this.right = right;
        this.index = index;
    }

    //sleep()方法让出CPU，不释放资源。
    public void thinking() throws InterruptedException{
        System.out.println(this + "thinking");
        Thread.sleep(thinkTime);
    }

    public void eating() throws InterruptedException{
        System.out.println(this + "eating");
        Thread.sleep(eatTime);
    }

    @Override
    public void run() {
        try{
            while ( !Thread.interrupted() ){
                thinking();

                System.out.println(this + "take the left");
                left.take();
                Thread.sleep(10);
                System.out.println(this + "going to take the right");
                right.take();
                System.out.println(this + "has took the right");
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
