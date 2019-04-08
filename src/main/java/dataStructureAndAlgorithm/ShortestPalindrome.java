package dataStructureAndAlgorithm;

public class ShortestPalindrome {
    private static String res = "";
    private static int max = 0;

    public static void main(String[] args) {
        String string = "abcbad";
        String longestPal = shortestPalindrome(string);
        System.out.println(longestPal);

    }

    // 子串是潜在的回文子串
    public static String shortestPalindrome(String s) {
        int j = 0;

        // 找出s对于s.reverse的子串
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
        }

        // 递归边界: s本身就是回文子串
        if (j == s.length()) {
            return s;
        }

        String suffix = s.substring(j);

        return new StringBuffer(suffix).reverse().
                append(shortestPalindrome(s.substring(0, j))).
                append(suffix).
                toString();
    }
}
