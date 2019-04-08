package oj.leetcode;

public class LargestRectangleInHistogram {

	public static int largestRectangleArea(int[] heights) {
        int area = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        for(int i = 0; i < heights.length; i++){
            if(stack.empty() || heights[stack.peek()] < heights[i])
                stack.push(i);
            
            else{
                int start = stack.pop();
                int width = stack.empty() ? i : i-stack.peek()-1;
                area = Math.max(area, heights[start]*width);
                System.out.println("i: " + i + " the start is: " + start + " the width is: " + width + " current area is" + area 
                		+ " heights[start]*width " + heights[start]*width);
                i--;
            }
        }
        
        
        while(!stack.empty()){
            int start = stack.pop();
            int width = stack.empty() ? heights.length : heights.length - stack.peek() - 1;
            area = Math.max(area, heights[start]*width);
        }
        
        return area;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a = {2,3,6,5,2,3};
		int largestArea = largestRectangleArea(a);
		System.out.println("the largest area is " + largestArea);
	}//main

}
