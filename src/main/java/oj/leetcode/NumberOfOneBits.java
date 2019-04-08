package oj.leetcode;

import java.util.Arrays;

public class NumberOfOneBits {

	public static void main(String[] args) {
		// TODO ??????????????
		int i = 0;
		long n = 42949295;
        for(; n != 0; n =n >>> 1)
            if(n % 2 == 1)  i++;
        String a = "abcdefg";
        String sa = a.substring(2);		//??a[2]?????????
        String sb = a.substring(2,3);	//??a[2]?????a[3]????????a[3]
//        System.out.println(sa);
//        System.out.println(sb);
//        System.out.println(i);

        String s = "anagram";
        String t = "anagrma";
        char[] sArr = s.toCharArray();  
        char[] tArr = t.toCharArray();  
          
        Arrays.sort(sArr);  
        Arrays.sort(tArr); 
        //
        System.out.println( String.valueOf(sArr).equals(String.valueOf(tArr)	)	);
	}

}
