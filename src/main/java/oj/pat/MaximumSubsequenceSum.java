package oj.pat;

import java.util.Scanner;

public class MaximumSubsequenceSum {
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		int[] a = new int[k];
		for (int i = 0; i < a.length; i++) 
			a[i] = input.nextInt();
		int low = 0;
		int high = a.length - 1;
		int[] result = findMaximumSubsequence(a, low, high);
		if(result[2] >= 0)
			System.out.print(result[2] + " " + result[0] + " " + result[1]);
		else
			System.out.print(result[2] + " " + a[0] + " " + a[(a.length - 1)]);
	}
	
	private static int[] findMaximumSubsequence(int[] a, int low, int high) {
		// TODO �Զ����ɵķ������
		if(high == low)
			return( new int[]{low, high, a[low]} );
		else {
			int mid = low + (high - low) / 2;
			int[] left = new int[3];
					left = findMaximumSubsequence(a, low, mid);
			int[] right = new int[3];
					right = findMaximumSubsequence(a, mid+1, high);
			int[] cross = new int[3];
					cross = findMaxCrossingSubsequence(a, low, mid, high);
			if( left[2] >= right[2]  &&  left[2] >= cross[2])
				return left;
			else if( right[2] > left[2]  &&  right[2] >= cross[2])
				return right;
			else
				return cross;
		}
	}

	private static int[] findMaxCrossingSubsequence(int[] a, int low, int mid, int high) {
		// TODO �Զ����ɵķ������
		int leftSum = -2147483648;
		int leftMax = mid;
		int sum = 0;
		for(int i = mid; i >= low; i--){
			sum += a[i];
			if(sum > leftSum){
				leftSum = sum;
				leftMax = i;
			}
		}
		sum = 0;
		int rightSum = -2147483648;
		int rightMax = mid + 1;
		for(int i = mid + 1; i <= high; i++){
			sum += a[i];
			if(sum > rightSum){
				rightSum = sum;
				rightMax = i;
			}
		}
		return ( new int[]{leftMax, rightMax, leftSum + rightSum} );
	}

}
