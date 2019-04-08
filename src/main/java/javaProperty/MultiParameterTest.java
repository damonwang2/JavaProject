package javaProperty;

public class MultiParameterTest {
    public static void main(String[] args) {
        test(1,2,3,4,5);
    }

    public static void test(Integer... integers) {
        System.out.println(integers.getClass());
        System.out.println(integers[1]);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}