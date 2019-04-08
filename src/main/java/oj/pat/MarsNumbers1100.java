package oj.pat;

import java.util.Scanner;

public class MarsNumbers1100 {
	static String[] genums = { "tret", "jan", "feb", "mar", "apr", "may", "jun", "jly", "aug", "sep", "oct", "nov", "dec"};
	static String[] shinums = {"", "tam", "hel", "maa", "huh", "tou", "kes", "hei", "elo", "syy", "lok", "mer", "jou"};

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String[] s = new String[10];
		for (int i = 0; i < n; i++) {
			s[i] = input.nextLine();
		}
		for (int i = 0; i < n; i++) {
			if( isEarth(s[i]) )
				System.out.println( tran2Mars(s[i]) );
			else
				System.out.println(tran2Earth(s[i]).toString());
		}
		
	}

	private static Integer tran2Earth(String s) {
		// TODO �Զ����ɵķ������
		String[] s1 = s.split(" ");
		int shi = 0;
		int ge = 0;
		// length����4��Ϊ��λ����
		if(s.contains(" ")){
			for (int i = 0; i < 13; i++) {
				if( shinums[i].equals(s1[0]))
					shi = i;
				if ( genums[i].equals(s1[1]))
					ge = i;
			}
		}
		else {
			for (int i = 0; i < 13 ; i++)
				if( s.equals(genums[i]))
					ge = i;
			for (int i = 0; i < 13  &&  shi != 0; i++)
				if( s.equals(shinums[i]))
					shi = i;
		}
		return shi * 13 + ge;
	}

	private static String tran2Mars(String s) {
		// ��ʮ�����ַ���ת��Ϊ��������
		int x = Integer.parseInt(s);
		if (x / 13 == 0)
			 return genums[x];
		else if (x % 13 == 0) 
			 return shinums[x % 13];  
		else 
			 return shinums[x / 13] + " " + genums[x % 13];
	}

	private static boolean isEarth(String s) {
		// TODO �Զ����ɵķ������
		if( '0' <= s.charAt(0)  &&  s.charAt(0) <= '9')
			return true;
		return false;
	}
}