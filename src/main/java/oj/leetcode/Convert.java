package oj.leetcode;

public class Convert {

    public static void main(String[] args) {
        String str = convert("PINALSIGYAHRPI", 4);
        System.out.println(str);
    }

    public static String convert(String s, int numRows) {

        // numRows为1的话，period则为0，会导致死循环
        if (numRows == 1) {
            return s;
        }

        int period = 2 * numRows - 2;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i += period) {
            int j = 0;

            // 竖着排列下来，j到numRows-1止
            while (j < numRows - 1 && i + j < s.length()) {
                stringBuilders[j].append(s.charAt(i + j));
                j++;
            }

            // 斜着排列, j = n-1, n - 1; j = n, n -2; j = n + 1, n - 3
            while (j < period && i + j < s.length()) {
                stringBuilders[period - j].append(s.charAt(i + j));
                j++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            res.append(stringBuilder);
        }

        return res.toString();
    }
}
