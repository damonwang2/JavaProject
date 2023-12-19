package javaProperty.extendsTest;

public interface SuperInterface {
    int a = 1;
    default String name() {
        return "super interface:" + a;
    }
}
