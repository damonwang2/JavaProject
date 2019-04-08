package javaProperty.java8;

/**
 * Created by pojun on 2019/1/13.
 */
public class DefaultMethod {
    public static void main(String[] args) {
        Vehicle vehicle = new Car2();
        vehicle.print();
    }
}

interface Vehicle {
    default void print() {
        System.out.println("我是一辆车!");
    }
}

interface FourWheeler {
//    default void print(){
//        System.out.println("我是一辆四轮车!");
//    }
}

class Car2 implements Vehicle, FourWheeler {
}
