package onlineExamination.netease2018_8;

import java.util.Scanner;

public class Main {
    public static
    void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            int[] t = new int[n];
            int[] kk = new int[n+1];
            for(int i = 0; i < n;i++){
                a[i] = scanner.nextInt();
            }
            for(int i = 0; i < n;i++){
                t[i] = scanner.nextInt();
            }

            //i代表叫醒时间
            for(int i =0;i< n-k+1;i++){
                int sum =0;
                for(int j = i;j < i+k;j++){
                    if(t[j]==0) {
                        sum += a[j];
                    }
                }
                kk[i] = sum;
            }
            int maxIndex=0;
            for(int i = 1;i < kk.length;i++){
                if(kk[i]>kk[maxIndex]){
                    maxIndex = i;
                }
            }
            for(int i = maxIndex;i<maxIndex+k;i++){
                t[i] = 1;
            }
            int sum =0;
            for(int i=0;i<n;i++){
                sum += t[i]*a[i];
            }
            System.out.println(sum);
        }
    }
}
