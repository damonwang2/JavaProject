package oj.pat;

import java.util.Scanner;

public class CountPAT1093 {

	static int pk = 0;
	static int aj = 0;
	static int ti = 0;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		
		char[] pat = s.toCharArray();
		int[] p = new int[pat.length];
		int[] a = new int[pat.length];
		int[] t = new int[pat.length];
		for (int i = 0; i < pat.length; i++) {
			if(pat[i] == 'P')
				p[pk++] = i;
			if(pat[i] == 'A')
				a[aj++] = i;
			if(pat[i] == 'T')
				t[ti++] = i;
		}
		int i = ti - 1, j = aj - 1, k = pk - 1;
		int sum = 0;
		while(i >= 0 && j >= 0 && k >= 0){
			
			while(a[j] > t[i] && j >= 0)
				j--;
			
			while(p[k] > a[j] && k >= 0)
					k--;
			
			sum += (j) * (k+1);
			i--;
			System.out.println(sum);
		}
		System.out.println(sum);
	}

}
