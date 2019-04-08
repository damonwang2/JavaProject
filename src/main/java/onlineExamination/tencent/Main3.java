package onlineExamination.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }

            Arrays.sort(nums);
            int count = 0;
            for (int j = n-1; j >= 2; j--) {
                int l = 0, r = j-1;
                while (l < r) {
                    if (nums[l] + nums[r] > nums[j]) {
                        count += r-l;
                        r--;
                    }
                    else l++;
                }
            }
            System.out.println(count);

        }
    }
}
