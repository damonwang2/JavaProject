package blog.philosopher;

public class Philosopher3 extends Philosopher{

    public Philosopher3(Chopstick left, Chopstick right, int index) {
        super(left, right, index);
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
                //如果右筷子正在使用，则放弃左筷子
                if(right.getIsUsing()){
                    left.drop();
                    System.out.println(this + "give up");
                }else {
                    right.take();
                    System.out.println(this + "has took the right");
                    eating();

                    left.drop();
                    right.drop();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
