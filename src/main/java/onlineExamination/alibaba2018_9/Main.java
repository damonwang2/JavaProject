package onlineExamination.alibaba2018_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt();
        int y0 = in.nextInt();

        List<Point> points = new ArrayList<>();

        while (in.hasNext()) {
            in.next();
        }

        System.out.println("yes,0");
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
