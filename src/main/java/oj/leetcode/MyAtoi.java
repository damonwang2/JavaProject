package oj.leetcode;

public class MyAtoi {

    public static void main(String[] args) {
        int res = myAtoi("words and 987");
        res = myAtoi("4193 with words");
        res = myAtoi("42");
        res = myAtoi("   -42");
        res = myAtoi("-91283472332");
        System.out.println(res);
    }

    public static int myAtoi(String str) {
        str = str.trim();

        // 原str只包含空格或者为空
        if (str.length() == 0) {
            return 0;
        }

        // 默认为正数
        boolean positive = true;

        int start = 0;
        if (str.charAt(0) == '-') {
            positive = false;
            start++;
        } else if (str.charAt(0) == '+') {
            start++;
        } else if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        }

        // 找到第一个不是0-9的字符下标
        int end = start;
        while (end < str.length() && str.charAt(end) >= '0' && str.charAt(end) <= '9') {
            end++;
        }

        String numStr = str.substring(start, end);
        int res;

        try {
            res = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            if (positive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if (!positive) {
            return -1 * res;
        }
        return res;
    }
}
