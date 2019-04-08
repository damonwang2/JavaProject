package oj.leetcode;

public class Multiply {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        String zero = "0";

        // m >= n
        if (m < n) {
            return multiply(num2, num1);
        }

        // 0处理
        if (n == 1) {
            if (zero.equals(num1) || zero.equals(num2)) {
                return zero;
            }
        }

        int[] res = new int[m+n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];

                // 同时修改余数和进位
                res[p1] += sum / 10;
                res[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : res) {
            // 不能都为0
            if(!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.toString();

    }
}
