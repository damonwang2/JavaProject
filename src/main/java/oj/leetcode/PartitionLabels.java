package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {

        // 判空
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        // record the last index of the each char
        int[] map = new int[26];

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }

        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            // 以start-i为子串，记录子串内部每个字符的最后一次出现的位置，取其中的最大值为last
            // 当到了last，则表示可以为一个子串
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
