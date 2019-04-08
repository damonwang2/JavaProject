package guava;


public class ConcurrentHashMapCacheTest {

    public static void main(String[] args) {
        
        final MyConcurrentHashMapCache<String,String> cache =
                new MyConcurrentHashMapCache<>();

        Thread t1=new Thread(() ->{
                System.out.println("T1======start========");
                Object value = cache.getCache("key","T1");
                System.out.println("T1 value = ============="+value);
                System.out.println("T1======end========");
        });

        Thread t2=new Thread(() -> {
                System.out.println("T2======start========");
                Object value = cache.getCache("key","T2");
                System.out.println("T2 value = ============="+value);
                System.out.println("T2======end========");
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T3======start========");
                Object value = cache.getCache("key","T3");
                System.out.println("T3 value = ============="+value);
                System.out.println("T3======end========");

            }
        });

        t1.start();
        t2.start();
        t3.start();

    }

}

