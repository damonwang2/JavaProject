package onlineExamination.pdd2;


import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        if (solution(str1, str2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean solution(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        String sortedStr1 = getSortedString(str1);
        String sortedStr2 = getSortedString(str2);

        if (!sortedStr1.equals(sortedStr2)) {
            return false;
        }

        int length = str1.length();
        for (int i = 1; i < length; i++) {
            // 交换发生在str1[1]的左孩子或者右孩子
            if (solution(str1.substring(0, i), str2.substring(0, i)) &&
                    solution(str1.substring(i), str2.substring(i))) {
                return true;
            }

            // str1[1]左孩子和右孩子交换
            if (solution(str1.substring(0, i), str2.substring(length - i)) &&
                    solution(str1.substring(i), str2.substring(0, length - i))) {
                return true;
            }
        }

        return false;
    }

    private static String getSortedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
