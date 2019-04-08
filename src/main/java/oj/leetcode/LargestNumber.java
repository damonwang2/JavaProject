package oj.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> numStrings = new ArrayList<>();
        for (int num : nums) {
            numStrings.add(String.valueOf(num));
        }

        Collections.sort(numStrings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        StringBuilder res = new StringBuilder();
        for (String str : numStrings) {
            if (res.length() == 0 && str.equals("0")) {
                continue;
            }
            res.append(str);
        }

        return res.toString();
    }
}
