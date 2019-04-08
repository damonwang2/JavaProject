package concurrence;

/**
 * Created by pojun on 2018/7/17
 */

public class FangLeiTest {
    public static void main(String[] args) {
        ResourceChar resource = new ResourceChar('a');
        for (int i = 0; i < 3; i++) {
            char char2 = (char) ('a' + i);
            new Thread(new ThreadPrint(char2, resource)).start();
        }
    }
}

class ResourceChar{
    public Character charCommon;

    public ResourceChar(Character charCommon) {
        this.charCommon = charCommon;
    }
}

class ThreadPrint implements Runnable {
    private int i = 0;
    private Character char2;
    private ResourceChar resource;

    @Override
    public void run() {
        while (i < 3) {
            print();
            Thread.yield();
            System.out.print(" ");
        }
    }

    public ThreadPrint(char char2, ResourceChar resource) {
        this.char2 = char2;
        this.resource = resource;
    }

    public void print() {
        synchronized(resource) {
            // 类似生产者
            if (char2 == resource.charCommon) {
                System.out.print(resource.charCommon);

                // 修改resource.charCommon，以便其他线程执行
                switch (resource.charCommon) {
                    case 'a': resource.charCommon = 'b';break;
                    case 'b': resource.charCommon = 'c';break;
                    case 'c': resource.charCommon = 'a';break;
                    default:break;
                }

                i++;
            }
//            resource.notifyAll();
        }
    }
}