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
    public static void test(Bird bird){
        System.out.println(bird.getName() + bird.fly());
    }
}

class Bird {
    private String name;

    public Bird(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int fly(){
        return 0;
    };
}

