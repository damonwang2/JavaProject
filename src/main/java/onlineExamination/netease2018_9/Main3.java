package onlineExamination.netease2018_9;

import java.util.Scanner;

public class Main3 {

    private static int numCandy = 0;
    private static int[] candidates;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 投票者和候选人
        int n = in.nextInt();

        // 表示或者的票的数量
        int m = in.nextInt();
        candidates = new int[m+1];

        Voter[] voters = new Voter[n+1];

        // i表示投票者
        for (int i = 1; i <= n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            voters[i] = new Voter(x, y);
            candidates[x]++;
        }

        fun(voters);

        System.out.println(numCandy);
    }

    public static void fun(Voter[] voters) {

        if (check(voters)) {
            return;
        }

        // 找出糖果数量最小且投票不是给1号的投票者
        int n = voters.length;

        int index = 0;
        int minCandy = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (voters[i].voteTo != 1 && voters[i].candy < minCandy) {
                minCandy = voters[i].candy;
                index = i;
            }
        }
        candidates[1]++;
        candidates[voters[index].voteTo]--;
        voters[index].voteTo = 1;
        numCandy += voters[index].candy;


        fun(voters);
    }

    public static boolean check(Voter[] voters) {

        for (int i = 2; i < voters.length; i++) {
            if (candidates[1] <= candidates[i]) {
                return false;
            }
        }
        return true;
    }
}

class Voter {
    int voteTo;
    int candy;

    public Voter(int voteTo, int candy) {
        this.voteTo = voteTo;
        this.candy = candy;
    }
}
