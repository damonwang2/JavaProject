package oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author pojun
 * @date 2020/6/18
 */
class LetterCombination {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> results = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        LinkedList<Character> processingList = new LinkedList<>();
        if (digits.length() != 0) {
            backtrace(processingList, digits, 0);
        }
        System.out.println(results);
        return results;
    }

    private void backtrace(LinkedList<Character> list, String digits, int index) {
        if (digits.length() <= index) {
            results.add(list.stream().map(Object::toString).collect(Collectors.joining()));
            return;
        }
        String key = String.valueOf(digits.charAt(index));
        String chars = phone.get(key);
        for (char ch : chars.toCharArray()) {
            list.push(ch);
            backtrace(list, digits, index+1);
            list.pop();
        }
    }

    public static void main(String[] args) {
        new LetterCombination().letterCombinations("23");
    }
}