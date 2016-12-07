package com.interview.tree;

import java.util.Stack;

/*
 *  Date: 6/12/2016
 *  @Author Karthekeyan
 *  
 *  Question: Binary Tree Right Side View
 *  
 *  	Input - Binary Tree
 *  
 *				     1
 *				   /   \
 *				  2     3
 *				 / \   / \
 *				4   5 6   7
 *			
 *		Output : Pre-Order Traversal -  1 2 4 5 3 6 7 (Root, Left, Right)
 *				  In-Order Traversal -   4 2 5 1 6 3 7 (Left, Root, Right)
 *				  Post-Order Traversal -	4 5 2 6 7 3 1 (Left, Right, Root)
 */

public class TreeTraversal {

	// PreOrder Recursive Method - Time Complexity: O(n) & Space Complexity: O(h)
	public void preOrderRM(TreeNode node) {
		if(node != null) {
			System.out.print(node.data + " ");
			preOrderRM(node.left);
			preOrderRM(node.right);
		}
	}

	// InOrder Recursive Method - Time Complexity: O(n) & Space Complexity: O(h)
	public void inOrderRM(TreeNode node) {
		if(node != null) {
			inOrderRM(node.left);
			System.out.print(node.data + " ");
			inOrderRM(node.right);
		}
	}

	// PostOrder Recursive Method - Time Complexity: O(n) & Space Complexity: O(h)
	public void postOrderRM(TreeNode node) {
		if(node != null) {
			postOrderRM(node.left);
			postOrderRM(node.right);
			System.out.print(node.data + " ");
		}
	}

	// PreOrder Iterative Method - Time Complexity: O(n) & Space Complexity: O(n)
	public void preOrderIM(TreeNode node) {

		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);

		while(!stack.isEmpty()) {
			TreeNode current = stack.pop();
			System.out.print(current.data + " ");
			if(current.right != null) stack.push(current.right);
			if(current.left != null) stack.push(current.left);
		}
	}

	// InOrder Iterative Method - Time Complexity: O(n) & Space Complexity: O(n)
	public void inOrderIM(TreeNode node) {

		Stack<TreeNode> stack = new Stack<>();
		while(node != null) {
			stack.push(node);
			node = node.left;
		}

		while(!stack.isEmpty()) {

			TreeNode current = stack.pop();
			System.out.print(current.data + " ");

			if(current.right != null) {
				TreeNode currentRight = current.right;
				stack.push(currentRight);

				while(currentRight.left != null) {
					stack.push(currentRight.left);
					currentRight = currentRight.left;
				}
			}
		}
	}

	// PostOrder Iterative Method - Time Complexity: O(n) & Space Complexity: O(n) - Two Stack Approach
	public void postOrderIM(TreeNode node) {

		Stack<TreeNode> dummyStack = new Stack<>();
		Stack<TreeNode> postStack = new Stack<>();
		
		dummyStack.push(node);
		
		while(!dummyStack.isEmpty()) {
			
			TreeNode current = dummyStack.pop();
			postStack.push(current);
			
			if(current.left != null) dummyStack.push(current.left);
			if(current.right != null) dummyStack.push(current.right);	
		}
		while(!postStack.isEmpty()) {
			TreeNode topNode = postStack.pop();
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

		TreeTraversal tree = new TreeTraversal();
		tree.preOrderRM(root); //  Recursive Method
		tree.inOrderRM(root); //  Recursive Method
		tree.postOrderRM(root); //  Recursive Method

		tree.preOrderIM(root); // Iterative Method
		tree.inOrderIM(root); // Iterative Method
		tree.postOrderIM(root); // Iterative Method
	}
}