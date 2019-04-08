package oj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode151 {
	static String[] sArr = { " ", " ", "abc", "def", "fhi","jkl", "mno", "pqrs", "tuvw", "wxyz"};
	public static void main(String[] args) {
		String digits = "1233";
		List<String> list = new LinkedList<String>();
        letter(digits, list);
        
        System.out.println(list);
			
	}
	private static void letter(String digits, List<String> list) {
		String s = "";
		if(digits == null){
			list.add(s);
			return;
		}
        int i = digits.indexOf(0);
        if(digits != null)
        	digits = digits.substring(1,digits.length());
        char c;
        for(int j = 0; j < sArr[i].toCharArray().length; j++){
        	c = sArr[i].toCharArray()[j];
        	s = s + c;
        	letter(digits, list);
        }
            
	}

}
