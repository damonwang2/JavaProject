package dataStructureAndAlgorithm;

public class CanJump {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canJump = new boolean[n];
        canJump[0] = true;

        for (int i = 0; i < n; i++) {
            if (canJump[i]) {
                // 将后面可以到达的点设置为true
                for (int j = 1; j <= nums[i] && (i + j) < n; j++) {
                    canJump[i + j] = true;
                }
            }
        }

        return canJump[n-1];
    }


}
