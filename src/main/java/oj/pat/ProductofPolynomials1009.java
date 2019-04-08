package oj.pat;

import java.util.Scanner;

public class ProductofPolynomials1009 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		
		int m = input.nextInt();
		int[] indexa = new int[m];
		double[] a = new double[m];
		for(int i = 0; i < m; i++){
			//a[i][0]:exponents  a[i][1]:coefficients
			indexa[i] = input.nextInt();
			a[i] = input.nextDouble();
		}
		
		int n = input.nextInt();
		int[] indexb = new int[n];
		double[] b = new double[n];
		for(int i = 0; i < n; i++){
			//a[i][0]:exponents  a[i][1]:coefficients
			indexb[i] = input.nextInt();
			b[i] = input.nextDouble();
		}
		
		int k = 0;
		int[] t = new int[m*n];
		double[] c = new double[2001];
		//***********������**********
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				//t[k]:exponents  a[i][1]:coefficients
				t[k] = indexa[i] + indexb[j];
				c[ t[k] ] += (a[i]*100) * (b[j]*10) / 100;
				k++;
			}
		}
		//***********����k�����*******
		k = 0;
		for(int i = 2000; i >= 0; i--)
			if( c[i] != 0)
				t[k++] = i;
		System.out.print(k);
		
		//**********���������***********
		for(int i = 0; i < k; i++)
			System.out.print( " " + t[i] +" " + c[ t[i] ]);
	}

}
