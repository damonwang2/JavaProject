package javaProperty.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author pojun
 * @date 2020/8/18
 */
public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        try {
            for (Integer integer : list) {
                list.remove(integer);
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            list.remove(iterator.next());
        }
    }
}