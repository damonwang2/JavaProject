package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Slf4jTest {
    public static void main(String[] args) {
        System.out.println("ClassLodarDemo's ClassLoader is " + Slf4jTest.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + Slf4jTest.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + Slf4jTest.class.getClassLoader().getParent().getParent());
    }
}
