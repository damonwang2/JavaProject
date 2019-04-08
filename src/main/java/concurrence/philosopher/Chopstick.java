package concurrence.philosopher;

public class Chopstick {
    private int index;
    private boolean isUsing = false;

    public Chopstick(int index){
        this.index = index;
    }

    @Override
    public String toString() {
        return "Chopstick [index = " + index + "]";
    }

    //对于一个成员方法加synchronized关键字
    public synchronized void take() throws InterruptedException{
        while(isUsing){
            wait();
        }
        isUsing = true;
    }

    public synchronized void drop(){
        isUsing = false;
        notifyAll();
    }
}



