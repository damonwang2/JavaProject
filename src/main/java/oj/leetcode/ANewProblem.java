package oj.leetcode;

public class ANewProblem {

	public static void main(String[] args) {

		int[] a = {2,4,3,5,4};
		int ar = largest(a);
		System.out.println(ar);
		long k =56793543;
		System.out.println(k*k);
	}

	// O(n) using one stack  
	public static int largest(int[] height) {  
	  // Start typing your Java solution below  
	  // DO NOT write main() function  
	  int area = 0;
	  int m = 0;
	  java.util.Stack<Integer> stack = new java.util.Stack<Integer>();  
	  for (int i = 0; i < height.length; i++) {  
	    if (stack.empty() || height[stack.peek()] < height[i]) {  
	      stack.push(i);
	      System.out.println("if:��"+m+"��"+stack+"iΪ��"+i);
	      m++;
	    } else {
	      System.out.println("else:"+stack+"iΪ"+i);
	      int start = stack.pop();  
	      int width = stack.empty() ? i : i - stack.peek() - 1;	//��Ϊ��һ������ջһ��
	      area = Math.max(area, height[start] * width);  
	      i--;  
	      System.out.println("����ǣ�"+area+"�߶��ǣ�"+height[start]+"���:"+width);
	    }  
	  }
	  System.out.println("forѭ���������area��"+area);
	  m = 1;
	  while (!stack.empty()) {  
	    int start = stack.pop();  
	    //��ǰ�����ҵ�������height[i]��
	    int width = stack.empty() ? height.length : height.length - stack.peek() - 1;  
	    area = Math.max(area, height[start] * width);
	    System.out.println("��"+m+"�Σ�"+area);
	    m++;
	  }  
	  System.out.println("whileѭ���������area��"+area);
	  return area;  
	}  
}
