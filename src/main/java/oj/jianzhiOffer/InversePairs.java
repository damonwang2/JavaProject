package oj.jianzhiOffer;

import java.util.Arrays;

/**
 * Created by Damon on 2017/7/18.
 */
public class InversePairs {

    public static void main(String[] args) {
        InversePairs object = new InversePairs();
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(object.InversePairs(array));
    }

    private int mod = 1000000007;

    public int InversePairs(int [] array) {
        // 数组length为0的特殊情况
        if (array.length == 0) {
            return 0;
        }

        int[] copy = Arrays.copyOf(array, array.length);
        return countInversePairs(array, copy, 0, array.length - 1);
    }

    // 使用递归需要注意递归边界
    public int countInversePairs(int[] array, int[] copy, int start, int end) {
        // 递归边界：数组长度为1
        if (start == end) {
            return 0;
        }

        // 采用归并排序来计算逆序对
        int mid = (start + end) >> 1;

        int leftCount = countInversePairs(array, copy, start, mid);
        int rightCount = countInversePairs(array, copy, mid + 1, end);
        int mergeCount = merge(array, copy, start, mid, end);

        return (leftCount + rightCount + mergeCount) % mod;
    }

    public int merge(int[] array, int[] copy, int start, int mid, int end) {
        int i = mid, j = end, k = end;
        int count = 0;

        while (i >= start && j >= (mid + 1)) {
            if (array[i] > array[j]) {
                count = (count + j - mid) % mod;
                copy[k--] = array[i--];

            } else {
                copy[k--] = array[j--];
            }
        }

        // 多余的数据需要复制
        if (i >= start) {
            System.arraycopy(array, start, copy, start, k - start + 1);
        } else {
            System.arraycopy(array, mid + 1, copy, start, k - start + 1);
        }

        System.arraycopy(copy, start, array, start, end - start + 1);

        return count % mod;
    }

}
