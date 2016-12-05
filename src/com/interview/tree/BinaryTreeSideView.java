package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  Date: 6/12/2016
 *  @Author Karthekeyan
 *  
 *  Question: Binary Tree Right Side View
 *  
 *  			Input Tree
 *  
 *				     1
 *				   /   \
 *				  2     3
 *				   \   
 *				    5    
 *			
 *		Output : 1 3 5
 *
 *  Question: Binary Tree Left Side View
 *  
 *  			Input Tree
 *  
 *				     1
 *				   /   \
 *				  2     3
 *				   \   
 *				    5    
 *			
 *		Output : 1 2 5
 */

public class BinaryTreeSideView {

	// Iterative Approach - Right Side View - Time Complexity: O(n) & Space Complexity: O(n)
	public void rightViewPrinting(TreeNode root) {

		System.out.println("Binary Tree Right Side View");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				if(i == 0) System.out.print(current.data + " ");	
				if(current.right != null) queue.add(current.right);
				if(current.left != null) queue.add(current.left);
			}
		}
	}
	
	// Iterative Approach - Left Side View - Time Complexity: O(n) & Space Complexity: O(n)
	public void leftViewPrinting(TreeNode root) {

		System.out.println("Binary Tree Left Side View");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				if(i == 0) System.out.print(current.data + " ");	
				if(current.left != null) queue.add(current.left);
				if(current.right != null) queue.add(current.right);
			}
		}
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);

		BinaryTreeSideView binaryTree = new BinaryTreeSideView();
		binaryTree.leftViewPrinting(root);
		binaryTree.rightViewPrinting(root);
	}
}