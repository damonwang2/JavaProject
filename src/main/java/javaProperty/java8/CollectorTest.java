package javaProperty.java8;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by pojun on 2019/1/7.
 */
public class CollectorTest {
    public static void main(String[] args) {
//        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
//
//        Function<Integer, Integer> function = i -> i / 2;
//        Map<Integer, Optional<Integer>> map = list.stream()
//                .collect(Collectors.groupingBy(function, Collectors.maxBy(Integer::compareTo)));
//
//        Map<Integer, Integer> map2 = list.stream()
//                .collect(Collectors.groupingBy(function, Collectors.collectingAndThen(Collectors.maxBy(Integer::compareTo), Optional::get)));
//
//        // 三个参数表示了，key生成器；value生成器；多个key下value的合并策略
//        list.stream().collect(Collectors.toMap(function, Function.identity(), BinaryOperator.maxBy(Integer::compareTo)));
//
//        list.stream().collect(Collectors.toMap(function, Function.identity(), Integer::sum));
//
//        Map<Boolean, List<Integer>> map3 = list.stream().collect(Collectors.groupingBy(i -> i % 2 == 0));
//
//        // 传入构造出来的新的ArrayLis
//        List<Integer> list2 = list.stream().collect(Collectors.toCollection(ArrayList::new));
//
//        Optional<Integer> optionalInteger = Optional.empty();
//        // flatMap就是一个会去掉包装的方法
//        optionalInteger.map(i -> i + 1);
//        System.out.println(optionalInteger.isPresent());
//
//        Map<Long, Float> time2value = new HashMap<>();
//        Map<Long, Float> time2averageValue = time2value.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getKey,
//                Collectors.collectingAndThen(Collectors.averagingDouble(Map.Entry::getValue), Double::floatValue)));
//
//        List<String[]> lines = Lists.newArrayList();
////        lines.stream().map(line -> li)
//        Map<String, List<Integer>> name2grade = new HashMap<>();
//        Map<String, Double> name2averageGrade = name2grade.entrySet().stream()
//                .collect(Collectors.toMap(Map.Entry::getKey,
//                        entry -> entry.getValue().stream().mapToDouble(Integer::doubleValue).average().getAsDouble()));
//
////        map.compute((k, v) -> );
    }
}
