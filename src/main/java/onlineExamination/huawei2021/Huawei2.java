package onlineExamination.huawei2021;

public class Huawei2 {

    public static void main(String[] args) {
        int[] lostPackage1 = new int[]{1, 5, 10};
        System.out.println(solution(lostPackage1, 1));

        int[] lostPackage2 = new int[]{4, 6, 20, 9990};
        System.out.println(solution(lostPackage2, 2));

        int[] lostPackage3 = new int[]{1500, 4100, 5000, 8000};
        System.out.println(solution(lostPackage3, 2));

        int[] lostPackage4 = new int[]{4, 699, 700, 9990};
        System.out.println(solution(lostPackage4, 2));

        int[] lostPackage5 = new int[]{100, 2700, 5100, 7498, 7499, 7500};
        System.out.println(solution(lostPackage5, 2));

    }

    private static int packageNum = 10000;

    private static int solution(int[] lostPackages, int addPackageNum) {
        // 补偿的大于等于丢失的，返回所有的包
        if (addPackageNum >= lostPackages.length) {
            return packageNum;
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0, j = i + addPackageNum + 1; j <= lostPackages.length; i++, j++) {
            int preLostPackage = lostPackages[i];
            // 虚拟化第10001为丢失的包，这样前面的最多就是10000个
            int postLostPackage = j == lostPackages.length ? packageNum + 1 : lostPackages[j];

            // 开区间
            int gap = postLostPackage - preLostPackage - 1;
            result = Math.max(result, gap);
        }
        return result;
    }
}
