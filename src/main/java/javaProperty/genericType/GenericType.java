package javaProperty.genericType;

import java.util.ArrayList;
import java.util.List;

public class GenericType {
    public static void main(String[] args) {

    }

    //如果两个都是List类型，过不了JDK1.8的编译，但是可以通过反编译后修改class文件执行
    public static String method(ArrayList<String> list){
        System.out.println("list method");
        return "";
    }

    public static int method(List<Integer> list){
        System.out.println();
        return 6;
    }
}
