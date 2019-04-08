package oj.pat;

import java.util.Scanner;

public class spellItRight2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int sum = 0;
		String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		int len = s.length();
		for(int i=0;i<len;i++)
	        sum=sum+s.charAt(i)-48;
		int i = 0;
		
		if( sum == 0 ){
	        System.out.print("zero");
	        return ;
	    }
		String sum1 = new String( new Integer(sum).toString() );
		int len1 = sum1.length();
		while(len1 != 1){
			System.out.print( nums[(sum1.charAt(i)) - 48] + " ");
			i++;
			len1--;
		}
		System.out.println( nums[(sum1.charAt(i)) - 48] );
	}
}
