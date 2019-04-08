package oj.jianzhiOffer;

/**
 * Created by Damon on 2017/7/8.
 */
public class movingCount {

    public static void main(String[] args) {
        movingCount m = new movingCount();
        System.out.println(m.movingCount(15, 20, 20));
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return helper(threshold, rows, cols, 0, 0, visited);
    }

    public int helper(int threshold, int rows, int cols, int i, int j, boolean[][] visited){
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || numSum(i) + numSum(j) > threshold){
            return 0;
        }
        visited[i][j] = true;
        return helper(threshold, rows, cols, i - 1, j, visited)
            +  helper(threshold, rows, cols, i + 1, j, visited)
            +  helper(threshold, rows, cols, i, j - 1, visited)
            +  helper(threshold, rows, cols, i, j + 1, visited)
            +  1;
    }

    public int numSum(int i){
        int sum = 0;
        while(i > 0){
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}