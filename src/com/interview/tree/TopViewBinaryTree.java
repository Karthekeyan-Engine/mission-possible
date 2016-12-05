package com.interview.tree;

/*
 *  Date: 5/12/2016
 *  @Author Karthekeyan
 *  
 *  Question: Top View of Binary Tree
 *  Description: Set of nodes visible when the tree is viewed from the top. 
 *  Given a binary tree, print the top view of it. The output nodes can be printed in any order. 
 *  
 *		  		       1
 *		 		     /   \
 *		 		   2       3
 *		 		  /  \    / \
 *		 		 4    5  6   7
 *		
 *		Top View of the Binary Tree
 *		4 2 1 3 7
 *		
 *	 		        1
 *	 		      /   \
 *	 		    2       3
 *	 		      \   
 *	 		        4  
 *	 		          \
 *	 		            5
 *	 		             \
 *	 		               6
 *
 *		Top View of the Binary Tree
 *		2 1 3 6
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class TreeNode {
	
	int data;
	TreeNode left, right;
	
	public TreeNode(int data) {
		this.data = data;
		left = right = null;
	}
}

// Every Queue item -> Node & Horizontal Distance of node from Root
class QueueItem {
	
	int horizontalDistance;
	TreeNode treeNode;
	
	public QueueItem(TreeNode tn, int hd) {
		treeNode = tn;
		horizontalDistance = hd;
	}	
}

class Tree {
	
	TreeNode root;
	
	public Tree() { root = null; }
	public Tree(TreeNode node) { root = node; }
	
	public void printTopView() {
		
		if(root == null) return;
		
		Set<Integer> set = new HashSet<>();

		Queue<QueueItem> queue = new LinkedList<>();
		queue.add(new QueueItem(root, 0));
		
		while(!queue.isEmpty()) {
			
			QueueItem currentQueueNode = queue.remove();
			int hzDistance = currentQueueNode.horizontalDistance;
			TreeNode currentTreeNode = currentQueueNode.treeNode;
			
			if(!set.contains(hzDistance)) {
				set.add(hzDistance);
				System.out.print(currentTreeNode.data + " ");
			}
			
			if(currentTreeNode.left != null) queue.add(new QueueItem(currentTreeNode.left, hzDistance - 1));
			if(currentTreeNode.right != null) queue.add(new QueueItem(currentTreeNode.right, hzDistance + 1));
		}	
	}
}

public class TopViewBinaryTree {

	public static void main(String[] args) {
			
		/* Binary Tree
		        1
		      /  \
		     2    3
		      \
		       4
		        \
		         5
		          \
		           6     */
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(5);
		root.left.right.right.right = new TreeNode(6);
		
		Tree tree = new Tree(root);
		System.out.println("Top View of the Binary Tree");
		tree.printTopView();
		
		System.out.println();
		
		/*   Binary Tree
				   1
			     /   \
			   2       3
			  /  \    / \
			 4    5  6   7  */
		
		TreeNode rootx = new TreeNode(1);
		rootx.left = new TreeNode(2);
		rootx.right = new TreeNode(3);
		rootx.left.left = new TreeNode(4);
		rootx.left.right = new TreeNode(5);
		rootx.right.left = new TreeNode(6);
		rootx.right.right = new TreeNode(7);
		
		Tree treex = new Tree(rootx);
		System.out.println("Top View of the Binary Tree");
		treex.printTopView();
	}
}
