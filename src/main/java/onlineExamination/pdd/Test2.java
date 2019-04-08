package onlineExamination.pdd;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] counts = new int[5];

        //统计数量为i的队伍的个数
        for(int i = 0; i < n; i++){
            counts[in.nextInt()]++;
        }

        int res = 0;

        //考虑人数为4的队伍
        res += counts[4];

        //考虑人数为3的队伍
        res += counts[3];
        counts[1] = Math.max(0, counts[1] - counts[3]);

        //考虑人数为2的队伍
        if(counts[2] % 2 == 0){
            res += counts[2] / 2;
        }else {
            res += (counts[2] / 2 + 1);
            counts[1] = Math.max(0, counts[1]-2);
        }

        //考虑人数为1的队伍
        res += (counts[1]+3) / 4;

        System.out.println(res);
    }
}
