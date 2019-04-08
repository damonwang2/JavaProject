package onlineExamination.fanglei_xiecheng;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        String[] numStrs = str.substring(1, str.length() - 1).split(",");
        int n = numStrs.length;

        int[] nums = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numStrs[i].trim());
        }

        int i = 0;
        while(0 <= i && i < n) {
            if (visited[i]) {
                System.out.println(false);
                return;
            }

            visited[i] = true;
            i += nums[i];
        }

        System.out.println(true);

    }
}
