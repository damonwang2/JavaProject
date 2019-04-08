package onlineExamination.meituan;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        int lens = s.length();
        int lent = t.length();
        int lenst = lens - lent;
        int count = 0;

        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        for(int i = 0; i <= lenst ; i++){
            for(int j = 0; j < lent; j++){
                if(chars[i+j] != chart[j]){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
