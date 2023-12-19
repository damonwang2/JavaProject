package concurrence;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private static
    AtomicInteger integer = new AtomicInteger();
    private static char end = ' ';
    public static void main(String[] args) throws Exception {
        String str = "alibaba";
        str += end;
        for (int i = 0; i < str.length(); i++) {
            Thread thread = newThread(str.length(), i, str.charAt(i));
            thread.start();
        }
        Thread.sleep(1000L);
    }

    private static Thread newThread(int length, int i, char c) {
        return new Thread(() -> {
            // 打印多少次自己定义
            for (int j = 0; j < 20;) {
                if (integer.get() % length == i) {
                    if (c == end) {
                        System.out.println(end);
                    } else {
                        System.out.print(c);
                    }
                    j++;
                    integer.addAndGet(1);
                }
            }
        });
    }
}
