package javaProperty.extendsTest;

public interface SuperInterface {
    default String name(){
        return "super interface";
    }
}
