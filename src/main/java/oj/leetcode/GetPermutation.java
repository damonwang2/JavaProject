package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        List<Integer> list = new ArrayList<>(n);
        backtrack(list, used, new MutableInteger(n));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : list) {
            stringBuilder.append(i+1);
        }
        return stringBuilder.toString();
    }

    private void backtrack(List<Integer> tempList, boolean[] used, MutableInteger k) {
        if (tempList.size() == used.length) {
            k.value--;
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                tempList.add(i);

                backtrack(tempList, used, k);
                if (k.value == 0) {
                    return;
                }

                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    class MutableInteger {
        int value;

        public MutableInteger(int value) {
            this.value = value;
        }
    }
}