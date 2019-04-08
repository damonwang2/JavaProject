package onlineExamination.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] origins = new int[3001][3001];
        Map<Point, Integer> originToSum = new HashMap<>();
        Map<Point, Integer> terminalToCounts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Point terminal = new Point(in.nextInt(), in.nextInt());
            int count = 1;
            if (terminalToCounts.containsKey(terminal)) {
                count += terminalToCounts.get(terminal);
            }
            terminalToCounts.put(terminal, count);
        }

        for (int i = 0; i < m; i++) {
            // 起点
            Point origin = new Point(in.nextInt(), in.nextInt());
            int sum = 0;

            // 优化起点相同的情况
            if (origins[origin.x][origin.y] != 0) {
//                sum = originToSum.get(origin);
                sum = origins[origin.x][origin.y];
            } else {

                for (Map.Entry<Point, Integer> terminalAndCount : terminalToCounts.entrySet()) {
                    Point terminal = terminalAndCount.getKey();
                    int count = terminalAndCount.getValue();
                    int curSum = 0;
                    curSum += Math.abs(origin.x - terminal.x);
                    curSum += Math.abs(origin.y - terminal.y);
                    sum += curSum * count;
                }
                origins[origin.x][origin.y] = sum;
//                originToSum.put(origin, sum);
            }

            System.out.println(sum);
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
