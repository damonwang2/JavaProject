package javaProperty.serialize;

/**
 * TODO
 *
 * @author pojun
 * @date 2020/1/9
 */

import java.io.*;

class Person implements Serializable {
    private String name;
    private transient int age;
    static String country = "cn";

    Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        Person.country = country;
    }

    @Override
    public String toString() {
        return name + ":" + age + ":" + country;
    }

}

public class Demo {
    static String path = "C:\\Users\\pojun\\IdeaProjects\\JavaProject\\src\\main\\java"
        + "\\javaProperty\\serialize\\obj.txt";
    public static void main(String[] args) throws Exception {
        //writeObj();
        readObj();
    }

    private static void writeObj() throws IOException {
        ObjectOutputStream oos =
            new ObjectOutputStream(new FileOutputStream(path));

        // 已经加载了Person类，并且经过构造函数，这个类的cn=kr
        // cn=kr与序列化无关
        Person p = new Person("zhangsan", 22, "kr");

        oos.writeObject(p);
        oos.close();

    }

    private static void readObj() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Person p = (Person)(ois.readObject());

        // ck=kr在toString调用的时候，去获取静态变量
        sop(p.toString());

    }

    private static void sop(Object obj) {
        System.out.println(obj);
    }
}