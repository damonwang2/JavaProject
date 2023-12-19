package concurrence;

import com.alibaba.fastjson.JSON;

public class VolatileTest {
    public volatile int count = 0;
    public transient int coun3 = 0;
    public int count2 = 0;
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new VolatileTest()));

//        for(int i = 0; i < 10; i++){
//            new Thread(() ->  {
//                for(int j = 0; j < 1000; j++){
//                    count++;
//                }
//            }).start();
//        }
//        try{
//            Thread.sleep(1000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(count);
    }
}
