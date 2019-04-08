package oj.jianzhiOffer;

/**
 * Created by Damon on 2017/7/18.
 */
public class touzi {

    public static void main(String[] args) {

    }

    public double[] solution(int n){
        int[] counts = new int[6*n+1];

        //i表示骰子个数
        for(int i = 1; i <= n; i++){
            //j表示点数，点数范围[i,6i]
            for(int j = 6*i; j >= i; j--){
                //更新点数，点数等于前6个点数的个数之和，i-1是上次循环的最小值
                //因为要用到上一次循环的值，所以采用从后往前赋值，不然新值会覆盖原来的值
                counts[j] = 0;
                for(int k = Math.max(i-1,j-6); k < j; k++){
                    counts[j] += counts[k];
                }
            }
        }
        return new double[17];
    }
}
