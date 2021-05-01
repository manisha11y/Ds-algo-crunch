package com.tree;

// Common Node class to reuse in BST implementations in the package
public class Node {
	int value;
	Node left;
	Node right;
	
	Node(int value){
		this.value = value;
		left = right = null;
	}

}
