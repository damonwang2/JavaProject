package javaProperty.singleton;

import java.lang.reflect.Constructor;

public class SingletonTest {
    public static void main(String[] args) {
        try{
            //获得构造器
            Constructor con = Singleton.class.getDeclaredConstructor();
            //设置为可访问
            con.setAccessible(true);
            //构造两个不同的对象
            Singleton singleton1 = (Singleton)con.newInstance();
            Singleton singleton2 = (Singleton)con.newInstance();
            //验证是否是不同对象
            System.out.println(singleton1.equals(singleton2));
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            //获得构造器
            Constructor con = SingletonEnum.class.getDeclaredConstructor();
            //设置为可访问
            con.setAccessible(true);
            //构造两个不同的对象
            SingletonEnum singleton1 = (SingletonEnum)con.newInstance();
            SingletonEnum singleton2 = (SingletonEnum)con.newInstance();
            //验证是否是不同对象
            System.out.println(singleton1.equals(singleton2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

enum SingletonEnum {
    INSTANCE;
}
