package oj.leetcode;

public class Rotate {
    public void rotate(int[][] matrix) {
        // 旋转90，通过轴对称+对称即可
        int m = matrix.length;

        for (int i = 0; i < m / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[m-i-1];
            matrix[m-i-1] = temp;
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
