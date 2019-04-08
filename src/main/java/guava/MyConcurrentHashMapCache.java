package guava;

import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMapCache<K,V> {

    private final ConcurrentHashMap<K, V> cacheMap = new ConcurrentHashMap<>();

    public V getCache(K key, String ThreadName){
        System.out.println(ThreadName + " getCache==============");

        //从缓存获取数据
        V value = cacheMap.get(key);
        //如果没有的话，把数据放到缓存
        if(value == null){
            return putCache(key, ThreadName);
        }
        return value;
    }

    public V putCache(K key, String ThreadName){
        System.out.println("ThreadName 执行业务数据并返回处理结果的数据（访问数据库等）" +
                "==============" + ThreadName);
        // 可以根据业务从数据库获取等取得数据,这边就模拟已经获取数据了

        // 把数据放到缓存
        // 现实情况一般会去数据库获取数据，这里直接new一个
        @SuppressWarnings("unchecked")
        V value = (V) (new Object());
        cacheMap.put(key, value);
        return value;
    }

}
