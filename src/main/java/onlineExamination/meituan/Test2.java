package onlineExamination.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if(str.length() == 0){
            System.out.println(0);
            return;
        }
        int[] counts = new int[10];
        int[] counts2 = new int[10];

        //计数
        for(char c : str.toCharArray()){
            counts[c-'0']++;
        }

        for(int i = 1; i < 10000; i++){
            Arrays.fill(counts2, 0);
            String stri = String.valueOf(i);
            for(char c : stri.toCharArray()){
                counts2[c-'0']++;
                if(counts2[c-'0'] > counts[c-'0']){
                    System.out.println(i);
                    return;
                }
            }
        }
        //找到出现次数最少的那个数字，如果有多个，取小的
        int posMin = 0;
        int min = counts[posMin];
        for(int i = 0; i < counts.length; i++){
            if(counts[i] < min){
                min = counts[i];
                posMin = i;
            }
        }

        //如果i = 0的话，在最前面加上1，就是累乘
        StringBuffer sb = new StringBuffer();
        if(posMin == 0) {
            sb.append(1);
        }

        while (min >= 0){
            sb.append(posMin);
            min--;
        }
        System.out.println(sb.toString());


    }
}
