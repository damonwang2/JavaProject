package javaProperty.reflect;

import java.lang.reflect.Field;
import java.util.Currency;

/**
 * @author pojun
 * @date 2020/8/3
 */
public class FieldTest {

    private static Field field;
    private static Father father = new Father();


    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
         field = father.getClass().getField("mFatherName");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
         father.mFatherName = "1";
        test();
        test2();
    }

    public static void test() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_000_000; i++) {
            father.getmFatherName();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void test2() throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_000_000; i++) {
            field.get(father);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}