package javaProperty.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pojun on 2019/1/13.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filteredList = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println(filteredList);

        System.out.println("筛选列表: " + filteredList);
        String mergedString = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining(", "));

        // 字符串拼接，可以用String.join()方法
        System.out.println("合并字符串: " + String.join(", ", strings));

        Integer[] ints = {1, 2, 3};
        // 方法引用：编译时需要同一类型
        // 如果用Integer::toString，Integer变为String类型
        // 这里用Object::toString,前后都是Object类型
        long result = Arrays.stream(ints)
                .map(Object::toString)
                .count();

        long res2 = strings.parallelStream()
                .filter(s -> !s.isEmpty())
                .count();

        System.out.println(result);
    }
}
