package onlineExamination.alibaba;

import java.util.Scanner;

/**
 * DFS，BFS，包括其他递归方法，保证其完整正确性首先要具有递归出口；
 * 其次，要考虑递归过程中是否携带 “状态记录”，若携带应注意记录的维护（自主维护还是递归栈“自己维护”）。
 * 由此引出一个，编程中的高效思想，即尽可能地不要直接使用形参。提倡方法内将参数进行拷贝，如此有利于
 * 状态与递归层次的对应关系（eg：下面代码中count+1优于count++，后者在回溯时需要--count）；
 * 当然，这不是一个“死规矩”，一些全局状态就需要我们在回溯的时候小心维护————恢复现场。其实操作系统本身
 * 也是如此工作的，保留现场出现在指令中断、函数调用等多种场合。
 */

public class Main {
    public static final Point ZERO = new Point(0,0);
    private static int min =Integer.MAX_VALUE;

    public static void main(String[] args){

        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Point[] points=new Point[n];

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] digits = line.split(",");
            points[i] = new Point(Integer.valueOf(digits[0]), Integer.valueOf(digits[1]));
        }

        int minDistance = calculate(ZERO, points, 0, 0);
        System.out.println(minDistance);
    }

    // 回溯
    public static int calculate(Point start,Point[] points,int sum,int count){
        for (int i = 0; i < points.length; i++) {
            if (points[i].visited == false) {
                points[i].visited = true;
                count++;
                sum += start.calDistance(points[i]);
                if (count == points.length) {
                    sum += points[i].calDistance(ZERO);
                    if (sum < min) {
                        min = sum;
                    }
                }
                // 以当前点为起点，去遍历剩下的点
                calculate(points[i],points,sum,count);
                points[i].visited=false;
                sum -= start.calDistance(points[i]);
                count--;
            }
        }
        return min;
    }
}


class Point{
    int x;
    int y;
    boolean visited;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calDistance(Point p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}