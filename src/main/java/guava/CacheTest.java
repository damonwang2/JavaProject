package guava;

import com.google.common.cache.*;

import javax.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CacheTest {

    private static final String KEY = "key";
    private static final String VALUE = "value";

    public static void main(String[] args) {

        RemovalListeners.asynchronous(System.out::println, Executors.newFixedThreadPool(2));

        // 创建者模式
        LoadingCache<String, String> stringCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .weakKeys()

                .removalListener(new RemovalListener<String, String>() {
                    public void onRemoval(RemovalNotification<String, String> removal) {
                        System.out.println(removal + " has been remove");
                    }
                })
//                .removalListener((removalNotification) -> System.out.println(removalNotification))
//                .removalListener(System.out::println)

                .build(new CacheLoader<String, String>() {
                    // 不在缓存中的数据，通过load方法加载
                            @Override
                            // Nonnull告诉编译期这个不能为空，空则警告
                            public String load(@Nullable String key) {
                                System.out.println("Get data from database");
                                return "valueInDatabase";
                            }
                });

            invalidTest(stringCache);
    }

    public static void getTest(LoadingCache<String, String> stringCache) {
        try {
            stringCache.get("");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        stringCache.getUnchecked("");

        try {
            // 输入为空，返回一个字符串
            stringCache.get("", () -> "");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void invalidTest(LoadingCache<String, String> stringCache) {

        stringCache.put(KEY, VALUE);
        try {
            // 两秒后开始访问，保证数据过期，需要重新load
            Thread.sleep(2000);
            stringCache.get(KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
