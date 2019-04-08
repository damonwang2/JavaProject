package blog;

import java.util.Arrays;

public class JavaAPIArrays {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] copy = Arrays.copyOf(array, 3);
        System.out.println(Arrays.asList(copy));

        int[] array1 = {1, 2, 3, 4, 5};
        Integer[] ints = new Integer[10];
        Arrays.fill(ints, 50);

        System.out.println(Arrays.asList(ints));
    }
}
