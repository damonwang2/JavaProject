package onlineExamination.fanglei_xiecheng;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String twoStr = in.next();

        String[] strings = twoStr.split(";");

        String str1 = strings[0];
        String str2 = strings[1];

        if (str1.length() != str2.length()) {
            System.out.println(false);
            return;
        }

        int length = str1.length();

        for (int i = 1; i < length - 1; i++) {
            if (str1.substring(0, i).equals(str2.substring(i)) &&
                    str1.substring(i).equals(str2.substring(0, i))) {
                System.out.println(true);
                return;
            }
        }

        System.out.println(false);

    }
}
