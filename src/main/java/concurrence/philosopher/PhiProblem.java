package concurrence.philosopher;

import java.util.concurrent.Semaphore;

class BufferSomething {
    public static Semaphore[] kuaiZi={new Semaphore(1),new Semaphore(1),new Semaphore(1),
            new Semaphore(1),new Semaphore(1)};

    public static Semaphore allowEat=new Semaphore(5);
}

class Phi implements Runnable {
    public int phiId;

    @Override
    public void run() {
        try {
            for(int i=0;i<5000;i++) {
                //BufferSomething的变量都是static的，可以获取
                BufferSomething.allowEat.acquire();
                //左右筷子
                BufferSomething.kuaiZi[phiId].acquire();
                BufferSomething.kuaiZi[(phiId+1)%5].acquire();
                System.out.println("phi:"+phiId+" eating and stop thinking");
                BufferSomething.kuaiZi[phiId].release();
                BufferSomething.kuaiZi[(phiId+1)%5].release();
                BufferSomething.allowEat.release();
                System.out.println("phi:"+phiId+" eated and start thinking");
            }
        } catch(Exception e) {
            System.out.println("error!!!");
        }
    }
}

public class PhiProblem{

    public static void main(String[] args) {

        for(int i=0;i<5;i++) {
            Phi phi=new Phi();
            phi.phiId=i;
            Thread phiThread=new Thread(phi);
            phiThread.start();
        }

    }
}