package oj.pat;

import java.util.Scanner;

public class WorldCupBetting1011 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		double[][] a = new double[3][3];
		double max = 0;
		int m = 0, n = 0, t = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = input.nextDouble();
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
						if(a[0][i] * a[1][j] *a[2][k] > max){
							max = a[0][i] * a[1][j] *a[2][k];
							m = i;
							n = j;
							t = k;
						}//if
				}//for3
			}//for2
		}//for1
		
		char[] twl  = {'W', 'T', 'L'};
		max = (a[0][m] * a[1][n] * a[2][t] * 0.65 - 1) * 2 + 0.005;
		System.out.printf("%c %c %c %.2f", twl[m], twl[n], twl[t], max);
		
	}

}
