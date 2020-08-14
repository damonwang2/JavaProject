package oj.leetcode;

/**
 * @author pojun
 * @date 2020/7/22
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z]", "");
        String reverseS = new StringBuilder().append(s).reverse().toString();
        return s.equals(reverseS);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba ,aba"));
    }
}