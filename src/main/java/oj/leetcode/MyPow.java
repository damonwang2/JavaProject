package oj.leetcode;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(-3 % 2);
    }
    public double myPow(double x, int n) {

        //n取-2147483648的时候，用int表示相反数会溢出，要用long long或者unsigned
        double ans = 1;
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1/x;
        }
        if (n % 2 == 1) {
            if (n > 0) {
                ans *= x;
            } else {
                ans = ans / x;
            }

        }
        return ans * myPow(x * x, n / 2);

    }
}
