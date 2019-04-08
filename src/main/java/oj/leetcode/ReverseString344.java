package oj.leetcode;

import java.util.Scanner;

public class ReverseString344 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		
		String s = input.nextLine();
		StringBuilder s1 = new StringBuilder(s);
		System.out.println(s1.reverse().toString());
	}

}
