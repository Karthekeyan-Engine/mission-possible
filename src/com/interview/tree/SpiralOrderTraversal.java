package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 *  Date: 6/12/2016
 *  @Author Karthekeyan
 *  
 *  Question: Spiral Order Traversal of a tree
 *  
 *  			Input Tree
 *  
 *				     1
 *				   /   \
 *				  2     3
 *				 / \   / \
 *				4   5 6   7
 *			
 *		Output : 1 2 3 7 6 5 4
 */


public class SpiralOrderTraversal {
	
	// Iterative Approach - Time Complexity: O(n) & Space Complexity: O(n)
	public void spiralPrinting(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		while(true) {
			
			while(!stack.isEmpty()) {
				TreeNode current = stack.pop();
				System.out.print(current.data + " ");
				if(current.left != null) queue.add(current.left);
				if(current.right != null) queue.add(current.right);
			}
			
			while(!queue.isEmpty()) {
				TreeNode current = queue.poll();
				System.out.print(current.data + " ");
				if(current.left != null) stack.add(current.left);
				if(current.right != null) stack.add(current.right);
			}
			if(stack.isEmpty() && queue.isEmpty()) break;
		}
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		SpiralOrderTraversal spiralTree = new SpiralOrderTraversal();
		System.out.println("Spiral Order Traversal");
		spiralTree.spiralPrinting(root);
	}	
}