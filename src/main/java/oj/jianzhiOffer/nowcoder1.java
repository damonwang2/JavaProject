package oj.jianzhiOffer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class nowcoder1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Set<Character> m = new HashSet<>();
        for(char c : s.toCharArray()) {
            m.add(c);
        }
        if(m.size() <= 2) {
            System.out.println(m.size());
        } else {
            System.out.println(0);
        }
        in.close();
    }
}

