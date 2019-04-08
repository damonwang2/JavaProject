package onlineExamination.pdd2;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Map<String, Integer> personAgeMap = new HashMap<>();
        String str1 = new String("a");
        String str2 = new String("a");

        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));

        personAgeMap.put(str1, 20);
        personAgeMap.put(str2, 21);

        System.out.println(personAgeMap.size());
    }
}

class Person {
    private String name;

    @Override
    public int hashCode() {
        return 0;
    }

}
