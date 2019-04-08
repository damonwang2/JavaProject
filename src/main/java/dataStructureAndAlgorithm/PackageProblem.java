package dataStructureAndAlgorithm;

public class PackageProblem {
    public static void main(String[] args) {
        int[] weights = {3, 2, 3, 4};
        int[] values = {5, 3, 5, 7};
        int m= 9;
        int result = solution(weights, values, m);
        System.out.println(result);
    }

    public static int solution(int[] weights, int[] values, int m){
        int n = weights.length;
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= m; j++){
//                if(weights[i-1]>j){
//                    dp[i][j] = dp[i-1][j];
//                }else {
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]);
//                }
//            }
            for(int j = m; j >= 1; j--){
                if(weights[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }

        return dp[n][m];
    }
}
