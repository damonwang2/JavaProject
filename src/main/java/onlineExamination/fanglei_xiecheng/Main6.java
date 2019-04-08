package onlineExamination.fanglei_xiecheng;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        String[] strings = str.split("\\|");

        int[][] matrix = new int[strings.length][];
        for(int i = 0; i < strings.length;i++){

            String[] strings1 = strings[i].split(",");

            matrix[i] = new int[strings1.length];
            for(int j = 0; j < strings1.length; j++){
                matrix[i][j] = Integer.valueOf(strings1[j].trim());
            }
        }
        System.out.println(searchMatrix(matrix,target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n;
        if (m == 0 || (n = matrix[0].length) == 0) {
            return false;
        }
        int row = 0, col = n - 1;

        while (row < m && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}