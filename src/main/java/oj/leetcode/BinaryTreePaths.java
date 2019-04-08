package oj.leetcode;

import java.util.ArrayList;

import java.util.List;

import java.util.Queue;

public class BinaryTreePaths {
	 public List<String> binaryTreePaths(TreeNode root) {
	        List list = new ArrayList();
	        
	        if(root == null)
	            return null;
	        Queue <TreeNode> queue = null;
	        queue.add(root);
	        
	        return null;
	    }
}

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
 }
