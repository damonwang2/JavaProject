package oj.leetcode;

public class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;

        // 异或
        if (dividend > 0 ^ divisor > 0) {
            sign = -1;
        }

        long dividend2 = Math.abs((long) dividend);
        long divisor2 = Math.abs((long) divisor);

        long res = 0;

        while (dividend2 >= divisor2) {
            long temp = divisor2, count = 1;

            while (dividend2 >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }

            dividend2 -= temp;
            res += count;
        }

        if (sign == -1) {
            res = -res;
        }

        return (int) res;
    }
}
