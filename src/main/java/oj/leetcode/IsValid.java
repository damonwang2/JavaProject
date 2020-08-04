package oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author pojun
 * @date 2020/6/18
 */
class IsValid {
    Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(',')');
        put('{','}');
        put('[',']');
    }};

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (ch != stack.peek()) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("{[]}"));;
    }
}