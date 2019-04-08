package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }

        backtrack(new ArrayList<>(), s, 0);

        return res;
    }

    public void backtrack(List<String> list, String s, int k) {
        if (k >= s.length() && !list.isEmpty()) {
            res.add(new ArrayList<>(list));
        }

        // i包括
        for (int i = k; i < s.length(); i++) {
            if (isPalindrome(s, k, i)) {
                list.add(s.substring(k, i + 1));
                backtrack(list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
