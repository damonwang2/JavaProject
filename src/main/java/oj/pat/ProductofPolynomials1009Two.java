package oj.pat;

import java.util.Scanner;

public class ProductofPolynomials1009Two {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int index = 0;
		double[] a = new double[1001];
		for(int i = 0; i < m; i++){
			//a[i][0]:exponents indicate the exponents
			index = input.nextInt();
			a[index] = input.nextDouble();
		}
		
		int n = input.nextInt();
		double[] b = new double[1001];
		for(int i = 0; i < m; i++){
			//a[i][0]:exponents indicate the exponents
			index = input.nextInt();
			a[index] = input.nextDouble();
		}
	}

}
