package com.examples.algorithms;

class Node {
	int key;
	Node left;
	Node right;
	
	Node(int item) {
		this.key = item;
	}
	
	public void setLeft(Node aLeft) {
		this.left = aLeft;
	}
	
	public void setRight(Node aRight) {
		this.right = aRight;
	}
}

public class BinaryTree {
	Node root;
	
	public void insert(int item) {
		this.root = insertRecord(root, item);
	}
	
	private Node insertRecord(Node aRoot, int newItem) {
		if(aRoot == null) {
			aRoot = new Node(newItem);
			return aRoot;
			
		}
		if(newItem < aRoot.key) {
			aRoot.left = insertRecord(aRoot.left, newItem);
		} else if (newItem > aRoot.key){
			aRoot.right = insertRecord(aRoot.right, newItem);
		}
		return aRoot;
	}
	
	public void traverse() {
		traverseNode(this.root);
	}
	
	private void traverseNode(Node aNode) {
		if(aNode!=null) {
			traverseNode(aNode.left);
			System.out.println(aNode.key);
			traverseNode(aNode.right);
		}
	}
	
	public boolean search(int item) {
		return searchTree(this.root, item);
	}
	
	private boolean searchTree(Node aRoot, int item) {
		if(aRoot == null) {
			return false;
		}
		if(aRoot.key == item) {
			return true;
		}
		if(aRoot.key > item) {
			return searchTree(aRoot.left, item);
		} else {
			return searchTree(aRoot.right, item);
		}
	}
	
	public int findMin() {
		return findMinRecord(this.root);
	}
	
	private int findMinRecord(Node aRoot) {
		if(aRoot == null) {
			return 0;
		}
		if(aRoot.left == null) {
			return aRoot.key;
		}
		return findMinRecord(aRoot.left);
	}
	
	public int findMax() {
		return findMaxRecord(this.root);
	}
	
	private int findMaxRecord(Node aRoot) {
		if(aRoot == null) {
			return 0;
		}
		if(aRoot.right == null) {
			return aRoot.key;
		}
		return findMaxRecord(aRoot.right);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(25);
		tree.insert(100);
		tree.insert(1);
		tree.insert(5);
		tree.insert(15);
		tree.insert(30);
		tree.insert(35);
		tree.insert(40);
		tree.insert(20);
		tree.traverse();
		System.out.println(tree.search(15));
		System.out.println(tree.root.key);
	}
}
