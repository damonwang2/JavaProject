package javaProperty.innerClass;

import java.lang.reflect.Constructor;

// 匿名内部类只能访问final字段
public class AnonymousInnerClass{
    public static void main(String[] args) {
        Bird bird = new Bird() {
            int i = 100;
            public int fly() {
                return 10000;
            }
            public String getName() {
                return "bird A";
            }
        };

//        System.out.println(bird);

        Class clazz = bird.getClass();
        System.out.println(clazz);

        try {
            Constructor constructor = clazz.getConstructor();
            //根据构造器创建实例
            Object obj = clazz.newInstance();
            System.out.println(obj);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

abstract class Bird {
    private String name;

    public Bird(){

    }
    public abstract String getName();
}

