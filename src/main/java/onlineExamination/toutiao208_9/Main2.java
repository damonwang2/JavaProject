package onlineExamination.toutiao208_9;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
            Arrays.fill(visited, new boolean[n]);
        }


        int count = 0;
        // 深搜
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    dfs(a, visited, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int[][] a, boolean[][] visited, int i, int j) {
        int n = a.length;
        a[i][j] = 0;
        int[][] gaps = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        for (int[] gap : gaps) {
            int i1 = i+gap[0], j1 = j + gap[1];

            if (i1 < 0 || i1 > n -1 || j1 < 0 || j1 > n-1) {
                continue;
            }

            if (a[i1][j1] == 1) {
                dfs(a, visited, i1, j1);
            }
        }

    }
}
