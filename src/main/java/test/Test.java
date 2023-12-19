package test;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

// 测试文件夹的不同
public class Test {
    public static void main(String[] args) {
        int n = 10;
        n = (n >>> 1);
        System.out.println(n >>> 1);
        Set<String> set = Sets.newHashSet("a", "a", "b");
        System.out.println(set);
        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>("a", "b");
        System.out.println(entry.getKey() + ":" +entry.getValue());

        ArrayList<Pair<String, Integer>> entries = new ArrayList<>();

        entries.add(new MutablePair<>("C", 20));        // 使用 `MutablePair`
        entries.add(new ImmutablePair<>("C++", 30));    // 使用 `ImmutablePair`
        entries.add(Pair.of("Java", 50));               // 使用 `Pair.of()`
        System.out.println(entries);
    }
}
