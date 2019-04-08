package onlineExamination.netease2018_8;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        int[] last = new int[n];
        // 递增的序列
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (i == 0) {
                last[i] = a[i];
            } else {
                last[i] = a[i] + last[i-1];
            }
        }

        // 待查找的序列
        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
            System.out.println(halfSearch(last, b[i]));
        }
    }

    public static int halfSearch(int[] last, int cur) {
        int min = 0, max = last.length;
        int mid = (min + max) / 2;

        // 找到第一个比cur大的数字
        while (min < max) {
            System.out.println(last[mid]);
            if (last[mid] == cur) {
                return mid+1;
            }

            if (last[mid] < cur) {
                min = mid + 1;
            } else {
                max = mid;
            }
            mid = (min + max) / 2;
        }

        return mid + 1;
    }

}
