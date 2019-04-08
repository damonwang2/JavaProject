package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class JoinerTest {
    public static void main(String[] args) {
        // Joiner源码分析
        // 构造函数私有，通过on来获取一个对象
        // 通过一系列的方法来指定特殊处理，这些方法都返回一个新的Joiner对象
        Joiner joiner = Joiner.on(";").skipNulls();
        String strings = joiner.join("Harry", "null", "Ron", "Hermione");

        System.out.println(strings);

        Iterable<String> stringIterable = Splitter.on(';').split(strings + ";");

        for (String str: stringIterable) {
            System.out.println("str:" + str);
        }
    }
}
