package oj.pat;

import java.util.Scanner;

public class signInAndSignOut {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int min = 0, max = 0;
		String[][] s = new String[n][3];
		for (int i = 0; i < n; i++) {
			s[i][0] = input.next();
			s[i][1] = input.next();
			s[i][2] = input.next();
		}
		
		for (int i = 1; i < n; i++) {
			if( s[i][1].compareTo( s[min][1]) < 0 )
				min = i;
			if( s[i][2].compareTo( s[max][2]) > 0 )
				max = i;
		}
		
		System.out.println(s[min][0] + " " + s[max][0]);
	}

}
