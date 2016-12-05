package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  Date: 5/12/2016
 *  @Author Karthekeyan
 *  
 *  Trivia - Original Tweet By Max Howell
 *  Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t 
 *  invert a binary tree on a whiteboard so fuck off.
 *  
 *  Question: Invert Binary Tree
 *  
 *  	Input - Binary Tree
 *  
 *				     1
 *				   /   \
 *				  2     3
 *				 / \   / \
 *				4   5 6   7
 *		
 *		Output - Binary Tree
 *
 *					 1
 *				   /   \
 *				  3     2
 *				 / \   / \
 *				7   6 5   4
 *
 *		Return the root
 */

public class InvertBinaryTree {

	// Inorder Traversal - Checker Method
	public void inorderTraversal(TreeNode node) {
		if(node != null) {
			inorderTraversal(node.left);
			System.out.print(node.data + " ");
			inorderTraversal(node.right);
		}
	}

	// Recursion Approach - Time Complexity: O(n) & Space Complexity: O(h)
	public static TreeNode invertBinaryTreeRecursion(TreeNode root) {

		if(root != null) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			if(root.left != null)  invertBinaryTreeRecursion(root.left);
			if(root.right != null)  invertBinaryTreeRecursion(root.right);	
		}
		return root;
	}

	//  Recursion Mirror Approach - Time Complexity: O(n) & Space Complexity: O(h)
	public static TreeNode mirror(TreeNode root) {

		if(root != null) {
			TreeNode left = mirror(root.left);
			TreeNode right = mirror(root.right);
			root.left = right;
			root.right = left;
		}
		return root;
	}

	// Iterative Approach - Time Complexity: O(n) & Space Complexity: O(n)
	public static TreeNode invertBinaryTreeIterative(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if(current.left != null) queue.add(current.left);
			if(current.right != null) queue.add(current.right);
		}
		return root;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		InvertBinaryTree binaryTree = new InvertBinaryTree();

		binaryTree.inorderTraversal(invertBinaryTreeRecursion(root));
		binaryTree.inorderTraversal(invertBinaryTreeIterative(root));
		binaryTree.inorderTraversal(mirror(root));
	}
}