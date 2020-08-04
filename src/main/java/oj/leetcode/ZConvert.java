package oj.leetcode;

public class ZConvert {
//    public String convert(String s, int numRows) {
//        if (numRows <= 1) {
//            return s;
//        }
//        int length = s.length();
//        char[] result = new char[length];
//        int count = 0;
//        int period = 2 * numRows - 2;
//
//        // 按照行遍历
//        for (int i = 0; i < numRows; i++) {
//            // j是周期数
//            for (int j = 0; j < (length -1) / period + 1; j++) {
//                int current = j * period + i;
//                if (current >= length) {
//                    break;
//                }
//
//                result[count++] = s.charAt(current);
//                current = j * period + period + 1 - i;
//                if (i != 0 && i != numRows - 1 && current < length) {
//                    result[count++] = s.charAt(current);
//                }
//            }
//        }
//
//        return new String(result);
//    }
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] results = new StringBuilder[numRows];


        int curRow = 0;
        int step = -1;
        // 模拟画Z的路线，将当前字符置于指定的数组中
        for (char c : s.toCharArray()) {
            results[curRow].append(c);
            // 遇到0或者numRows-1要掉头，
            if (curRow == 0 || curRow == numRows - 1) {
                step = -step;
            }
            curRow += step;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : results) {
            res.append(stringBuilder);
        }

        return res.toString();
    }

    public static void main(String[] args) {
//        new ZConvert().convert("PAYPALISHIRING", 3);
        System.out.println(1534236469 * 10);
    }
}
