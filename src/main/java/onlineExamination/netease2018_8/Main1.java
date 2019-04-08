package onlineExamination.netease2018_8;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Tower[] towers = new Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(i, in.nextInt());
        }

        // 操作
        int min = 0;
        int max = towers.length - 1;
        int count = 0;
        int[][] operation = new int[k][2];

        for (int i = 0; i < k + 1; i++) {
            Arrays.sort(towers);

            int gap = towers[max].height - towers[min].height;
            // 如果gap满足<=1，或者操作次数到了则结束
            if (gap <= 1 || i == k) {
                count = i;
                System.out.println( gap + " " + (count));

                break;
            }

            // 每操作一次放到数组里面去
            operation[i][0] = towers[max].index;
            operation[i][1] = towers[min].index;

            towers[max].height--;
            towers[min].height++;
        }

        for (int i= 0; i < count; i++) {
            System.out.println((operation[i][0]+1) + " " + (operation[i][1]+1));
        }

    }
}
class Tower implements Comparable<Tower> {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }

    @Override
    public int compareTo(Tower tower) {
        if (height != tower.height) {
            return height - tower.height;
        }
        return index - tower.index;
    }
}
