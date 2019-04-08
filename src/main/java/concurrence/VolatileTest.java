package concurrence;

public class VolatileTest {
    private volatile static int count = 0;
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(() ->  {
                for(int j = 0; j < 1000; j++){
                    count++;
                }
            }).start();
        }
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
