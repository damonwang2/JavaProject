package oj.pat;

import java.util.Scanner;

public class MaximumSubsequenceSum1007Two {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		int[] a = new int[10001];  
		int n, sum = -1, tmp, start = 0, end = a.length-1;  
		n = input.nextInt(); 
		for (int i = 0; i < n; i++)  
		a[i] = input.nextInt();
		  
		for (int i = 0; i < n; i++){  
		    tmp = 0;  
		    for (int j = i; j < n; j++){  
		    	tmp += a[j];  
		        if (tmp > sum){  
		        	sum = tmp;  
		            start = a[i];  
		            end = a[j];  
		            }  
		        }  
		}  
		if (sum < 0)
		    System.out.print(0 + " " + a[0] + " " + a[a.length-1]);  
		else
			System.out.print(sum + " " + start + " " + end); 
	}
}
