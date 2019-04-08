package javaProperty.annotation;

public class Test {

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.getName());
        dog.getProperty();
    }
}
