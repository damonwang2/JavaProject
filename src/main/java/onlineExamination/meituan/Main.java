package onlineExamination.meituan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] char1 = in.next().toCharArray();
        char[] char2 = in.next().toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;
        int lend = len1 - len2;

        long res = 0;
        for(int i = 0; i <= lend ; i++){
            for(int j = 0; j < len2; j++){
                if(char1[i+j] != char2[j]){
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
