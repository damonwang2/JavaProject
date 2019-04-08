package javaProperty.genericType;

public class Test {
    public static void main(String[] args) {
        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());

        //不能存元素，因为编译期只知道是Fruit的子类，不知道是什么类型，
//        plate.setItem(new Fruit());
//        plate.setItem(new Apple());

        Fruit fruit = plate.getItem();

        Plate<? super Fruit> plate1 = new Plate<Fruit>(new Fruit());
        plate1.setItem(new Fruit());
        plate1.setItem(new Apple());

        //取出东西只能放在Object中，因为编译期知道是Fruit的父类，具体什么类未知
    }
}
