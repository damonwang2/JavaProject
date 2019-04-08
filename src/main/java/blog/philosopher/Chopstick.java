package blog.philosopher;

public class Chopstick {
    private int index;
    private boolean isUsing = false;

    public Chopstick(int index){
        this.index = index;
    }

    //修改toString方法，因为System.out.println()输出对象都是调用toString方法
    @Override
    public String toString() {
        return "Chopstick [index = " + index + "]";
    }

    //对于一个成员方法加synchronized关键字，作用范围是从调用该方法开始，作用对象是该方法所在的对象
    public synchronized void take() throws InterruptedException{
        while(isUsing){
            wait();
        }
        isUsing = true;
    }

    //使用结束，通知所有其他线程
    public synchronized void drop(){
        isUsing = false;
        notifyAll();
    }

    public int getIndex() {
        return index;
    }

    public boolean getIsUsing(){
        return isUsing;
    }
}



