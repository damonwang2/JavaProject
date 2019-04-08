package oj.leetcode;

import java.util.ArrayList;

	
public class TestStringBuilder {
	
	 public int MinT(int t1, int t2, int t3) {
			int min = t1 < t2 ? t1 : t2;
			return min < t3 ? min : t3;
		}
	 
	 public int nthUglyNumber(int n) {
			int[] uglyNums = new int[n];
			int next = 1;
			int i=0, j=0, k=0;			//�ֱ��¼t2,t3,t5��ǰλ��
			uglyNums[0] = 1;
			
			while(next < n) {
				int min = MinT(uglyNums[i]*2, uglyNums[j]*3, uglyNums[k]*5);
				uglyNums[next] = min;
				
				if(uglyNums[i]*2 == min) i++;
				if(uglyNums[j]*3 == min) j++;
				if(uglyNums[k]*5 == min) k++;
				System.out.print(uglyNums[next - 1] + "\t");
				next++;
			}
			
			return uglyNums[n-1];
		}
	public static void main(String[] args) {
		TestStringBuilder t = new TestStringBuilder();
		int uglyNumber = t.nthUglyNumber(10);
		System.out.println(uglyNumber);
	}

}
