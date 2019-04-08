package oj.leetcode;

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix[0].length;

        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == matrix[mid/n][mid%n]) {
                return true;
            } else if (target > matrix[mid/n][mid%n]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
