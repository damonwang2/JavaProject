package oj.leetcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        System.out.println(read(100L));
        System.out.println(read(12345678L));
    }

    private static long yi = 10000_0000L;
    private static long wan = 10000L;

    private static String read(long l) {
        long a = l / yi;
        long b = l % yi / wan;
        long c = l % wan;

        String res = "";
        if (a > 0) {
            res += (readNumLessWan(a) + "亿");
        }
        if (b > 0) {
            res += readNumLessWan(b) + "万";
        }
         res += readNumLessWan(c);
        if (res.startsWith("零")) {
            return res.substring(1);
        }
        return res;
    }

    private static String[] strs = new String[]{"", "十", "百", "千"};

    private static String readNumLessWan(long l) {
        long[] res = new long[4];
        // 小端
        for (int i = 0; l > 0;i++) {
            res[i] = (l % 10);
            l /= 10;
        }
        String str = "";
        for (int i = 3; i >= 0; i--) {
            if (i != 3 && res[i + 1] == 0
                    && (str.length() == 0 || str.charAt(str.length()-1) != '零')) {
                str += '零';
            }
            if (res[i] > 0) {
                str += (res[i] + strs[i]);
            }
        }
        if (str.charAt(str.length()-1) == '零') {
            return str.substring(0, str.length()-1);
        }
        return str;
    }
}
