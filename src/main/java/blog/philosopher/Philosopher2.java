package blog.philosopher;

public class Philosopher2 extends Philosopher{
    //构造方法
    public Philosopher2(Chopstick left, Chopstick right, int index) {
        super(left, right, index);
    }

    @Override
    public void run() {
        try{
            while ( !Thread.interrupted() ){
                thinking();

                System.out.println(this + "take the small");
                Chopstick small = left.getIndex() < right.getIndex() ? left : right;
                small.take();

                Thread.sleep(10);

                Chopstick big = left.getIndex() > right.getIndex() ? left : right;
                System.out.println(this + "going to take the big chopstick" + big.getIndex());
                big.take();
                System.out.println(this + "has took the big right" + big.getIndex());
                eating();

                big.drop();
                small.drop();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}