package onlineExamination.toutiao208_9;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        // -1表示没有出现过
        int ans = 0, left = -1, len = s.length();
        int[] last = new int[255];
        Arrays.fill(last, left);

        for (int i = 0; i < len; i++) {
            // 上次出现位置在当前记录边界之后，即该子串中出现了重复字符，需调整left使得子串合法
            if (last[s.charAt(i)] > left)
                left = last[s.charAt(i)];
            ans = Math.max(ans, i - left);

            last[s.charAt(i)] = i;
        }

        System.out.println(ans);
    }
}
