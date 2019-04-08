package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pojun on 2019/1/7.
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        Long i = 1L;
        System.out.println(map.containsKey(i));
    }
}
