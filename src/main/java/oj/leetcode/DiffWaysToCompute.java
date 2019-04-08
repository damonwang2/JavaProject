package oj.leetcode;

import java.util.LinkedList;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> res = new LinkedList<Integer>();
        
        // 每一个符号都可以拆分为两个子式
        for (int i = 0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+' ) {

                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);

                List<Integer> leftRet = diffWaysToCompute(part1);
                List<Integer> rightRet = diffWaysToCompute(part2);

                for (Integer p1 : leftRet) {
                    for (Integer p2 : rightRet) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1 + p2;
                                break;
                            case '-': c = p1 - p2;
                                break;
                            case '*': c = p1 * p2;
                                break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        
        // 只有一个数，没有符号，直接作为结果
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        
        return res;
    }
}
