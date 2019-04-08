package oj.leetcode;

public class MatrixScore {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;

        // 翻转行
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                reverseRow(A, i);
            }
        }

        // 翻转列
        for (int j = 0; j < n; j++) {
            int countOfZero = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 0) {
                    countOfZero++;
                }
            }
            if (countOfZero > m / 2) {
                reverseColumn(A, j);
            }
        }

        // 计算最后的结果
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                num = num * 2 + A[i][j];
            }
            sum += num;
        }

        return sum;

    }

    private void reverseRow(int[][] a, int i) {
        for (int j = 0; j < a[i].length; j++) {
            if (a[i][j] == 0) {
                a[i][j] = 1;
            } else {
                a[i][j] = 0;
            }
        }
    }

    private void reverseColumn(int[][] a, int j) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][j] == 0) {
                a[i][j] = 1;
            } else {
                a[i][j] = 0;
            }
        }
    }
}
