package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 *  Date: 6/12/2016
 *  @Author Karthekeyan
 *  
 *  Question: Reverse Order Traversal of a tree
 *  
 *  			Input Tree
 *  
 *				     1
 *				   /   \
 *				  2     3
 *				 / \   / \
 *				4   5 6   7
 *			
 *		Output : 4 5 6 7 2 3 1
 */

public class ReverseOrderTraversal {
	
	public void reversePrinting(TreeNode root) {
		
		if(root == null) return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		Stack<TreeNode> stack = new Stack<>();
		
		while(!queue.isEmpty()) {
			
			TreeNode current = queue.poll();
			stack.push(current);
			
			if(current.right != null) queue.add(current.right);
			if(current.left != null) queue.add(current.left);
		}
		while(!stack.isEmpty()) {
			TreeNode topNode = stack.pop();
			System.out.print(topNode.data + " ");
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
		
		ReverseOrderTraversal reverseTree = new ReverseOrderTraversal();
		System.out.println("Reverse Order Traversal");
		reverseTree.reversePrinting(root);
	}
}