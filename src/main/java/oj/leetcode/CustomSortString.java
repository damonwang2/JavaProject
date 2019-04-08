package oj.leetcode;

public class CustomSortString {
    public String customSortString(String S, String T) {

        int[] count = new int[26];

        // 计数排序
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            // 添加count个字符c到sb中
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }    // sort chars both in T and S by the order of S.
        }

        // 还有部分字符在T中，不在S，需要添加
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }   // group chars in T but not in S.
        }
        return sb.toString();
    }
}
