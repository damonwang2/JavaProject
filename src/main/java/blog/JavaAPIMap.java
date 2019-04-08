package blog;

import java.util.*;

public class JavaAPIMap {
    public static void main(String[] args) {
        //新建一个空的Map
        Map<String, Integer> map = new HashMap<String, Integer>();
        //添加值
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        //1. foreach 配合 entrySet()
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("------------------");

        //2. foreach配合keySet()和get()
        for (String key : map.keySet()) {
            System.out.println("Key = " + key + ", Value = " + map.get(key));
        }
        System.out.println("------------------");

        //3. 迭代器Iterator配合entrySet()
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("------------------");

        //4. 迭代器Iterator配合keySet()和get()
        Iterator<String> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()){
            String key = keyIterator.next();
            System.out.println("Key = " + key + ", Value = " + map.get(key));
        }
    }
}
