package dataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class DfsOfHorse {
    private static int count = 0;
    private static int[] sx = {1, 1, -1, -1, 2, 2, -2, -2};
    private static int[] sy = {2, -2, 2, -2, 1, -1, 1, -1};
    private static boolean[][] visited = new boolean[100][100];
    private static int m = 5;
    private static int n = 4;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        int x = 0, y = 0;
        dfs(1, x, y);
        System.out.println(count);
    }

    private static void dfs(int pointsVisited, int x, int y) {

        visited[x][y] = true;

        if (pointsVisited == m * n) {
            count++;

            for(List l : list){
                System.out.print(l + "");
            }
            System.out.println();
        }

        for (int i = 0; i < sx.length; i++) {
            int nextX = x + sx[i];
            int nextY = y + sy[i];

            // 访问剩下的点
            if (nextX >= 0 && nextX < m &&
                    nextY >= 0 && nextY < n &&
                    !visited[nextX][nextY]) {

                ArrayList<Integer> current = new ArrayList<>();
                current.add(nextX);
                current.add(nextY);
                list.add(current);

                dfs(pointsVisited + 1, nextX, nextY);

                list.remove(list.size()-1);
                visited[nextX][nextY] = false;
            }
        }
    }
}