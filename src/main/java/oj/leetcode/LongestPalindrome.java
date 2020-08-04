package oj.leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String result = null;
        boolean[][] a = new boolean[s.length()][s.length()];
        // 长度，起始节点
        for (int length = 1; length <= s.length(); length++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + length - 1;
                if (j == s.length()) {
                    break;
                }

                if (length <= 2) {
                    a[i][j] = a[i] == a[j];
                } else {
                    a[i][j] = a[i+1][j-1] && (a[i] == a[j]);
                }

                if (a[i][j]) {
                    result = s.substring(i, j+1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("babcd");
    }
}
