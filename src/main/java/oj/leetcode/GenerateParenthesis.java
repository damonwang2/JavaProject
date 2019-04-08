package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(new StringBuffer(), 0, 0, n);
        return res;
    }

    public void backtracking(StringBuffer stringBuffer, int left, int right, int n){
        if (left + right == 2 * n) {
            res.add(stringBuffer.toString());
            return;
        }

        if (left < n) {
            backtracking(stringBuffer.append("("), left + 1, right, n);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (right < n) {
            backtracking(stringBuffer.append(")"), left, right + 1, n);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
