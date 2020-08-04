package javaProperty.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

public class Test {
    public static void main(String[] args) throws Exception {
        String str = "0000123";
        String newStr = str.replaceAll("^(0+)", "");
        System.out.println(newStr);
        //Field field = Father.class.getDeclaredField("name");
        //field.setAccessible(true);
        //Father father = new Father("test");
        //int n = 1;
        //
        //System.out.println("***一亿次测试***");
        //
        //long start = System.currentTimeMillis();
        //for (int i = 0; i < n; i++) {
        //    field.set(father, field.get(father) + "1");
        //}
        //long end = System.currentTimeMillis();
        //System.out.println(String.format("反射耗费了%sms", end -start));
        //System.out.println(father.getName());

    }
}
