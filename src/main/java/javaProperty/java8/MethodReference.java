package javaProperty.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by pojun on 2019/1/13.
 */
public class MethodReference {
    public static void main(String[] args) {
        Car car = Car.create(Car::new);
        List< Car > cars = Arrays.asList(car);

        // 静态方法
        cars.forEach(Car::collide);

        // 特定类的普通方法
        cars.forEach(Car::repair);

        // 特定对象的普通方法
        final Car police = Car.create( Car::new );
        cars.forEach(police::follow);
    }

}
class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
