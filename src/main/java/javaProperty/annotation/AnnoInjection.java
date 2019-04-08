package javaProperty.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnoInjection {

    public static Object getBean(Object obj) {
        try {
            // 获得类属性
            Field[] fields = obj.getClass().getDeclaredFields();
            // 遍历属性
            for (Field field : fields) {
                // 获得属性上的注解
                Seven s = field.getAnnotation(Seven.class);
                if (s != null) {
                    System.err.println("注入" + field.getName() + "属性" + "tt" + s.value());
                    // 反射调用public set方法,如果为访问级别private,那么可以直接使用属性的set(obj,value);
                    obj.getClass()
                            .getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
                                    new Class[] { String.class })
                            .invoke(obj, s.value());
                }
            }
            // 获得所有方法
            Method m[] = obj.getClass().getDeclaredMethods();
            for (Method mm : m) {
                // 获得方法注解
                Seven s = mm.getAnnotation(Seven.class);
                if (s != null) {
                    System.err.println("注入" + mm.getName() + "方法" + "t" + s.Property());
                    mm.invoke(obj, s.Property());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
