package concurrence;

import java.util.LinkedList;
import java.util.Queue;

//使用阻塞队列BlockingQueue解决生产者消费者
public class ConsumerProducerSynchronized {
    public static void main(String[] args) {
        //缓冲区
        final Queue queue = new LinkedList();

        Thread producer1 = new Producer1(queue, 5);
        Thread producer2 = new Producer1(queue, 5);

        Thread consumer1 = new Consumer1(queue);
        Thread consumer2 = new Consumer1(queue);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}

class Producer1 extends Thread{
    private Queue queue;
    private int capacity;
    private int i = 0;

    public Producer1(Queue queue, int capacity){
        this.queue = queue;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        while(true) {

            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }

            synchronized (queue) {
                //waiting condition - wait until Queue is not empty
                if (queue.size() <= capacity) {
                    i++;
                    queue.add(i);
                    System.out.println("Produce" + i);
                    queue.notify();
                }else {
                    try {
                        queue.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }//while
    }
}

class Consumer1 extends Thread{
    private Queue queue;
    public Consumer1(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
//        while(true) {
//            synchronized (queue) {
//                //waiting condition - wait until Queue is not empty
//                if(queue.size() > 0){
//                    int number = (Integer) queue.poll();
//                    System.out.println("Consum" + number);
//                    queue.notifyAll();
//                }else{
//                    try {
//                        //如果没有资源，则消费者进入等待状态
//                        System.out.println("consumer is waiting");
//                        queue.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }

        synchronized (queue) {
            while (queue.size() <= 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int number = (Integer) queue.poll();
            System.out.println("Consum" + number);
            queue.notifyAll();
        }
    }
}


