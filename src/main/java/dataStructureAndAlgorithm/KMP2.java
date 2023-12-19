package dataStructureAndAlgorithm;

public class KMP2 {
    public static void main(String[] args) {
        int k =new KMP2().strStr("ababcabcacbab", "abcac");
        System.out.println(k);
    }
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        int count = 0;
        for (int i = 0, j = 0; i < n; i++) {
            count++;
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
                count++;
                System.out.println("i=" + i +"，j=" + j);
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            System.out.println("i=" + i +"，j=" + j);
            if (j == m) {
                System.out.println(count);
                return i - m + 1;
            }
        }
        System.out.println(count);
        return -1;
    }
}