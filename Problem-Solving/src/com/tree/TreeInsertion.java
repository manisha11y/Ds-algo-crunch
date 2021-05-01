package com.tree;
//import com.tree.Node;

public class TreeInsertion {

	/*
	 * In this iterative approach I am trying to stick on the root and just keep on
	 * traversing the Node by .left and .right without loosing the root ptr, once we
	 * find the null in root.left we will initial root.left with newNode
	 */

	// time: O(long(n)) space: O(1)
	public Node iterativeInsert(Node root, int value) {

		Node newNode = new Node(value);
		if (root == null) {
			return newNode;
		} else {
			while (root != null) {
				if (value < root.value) {
					if (root.left == null) {
						root.left = newNode;
						return root;
					} else
						root = root.left;
				}

				else if (value > root.value) {
					if (root.right == null) {
						root.right = newNode;
						return root;
					} else
						root = root.right;
				}

			}
			return root;
		}

	}

	// recursive approach for BST insertion
	// time: O(long(n)) space: O(long(n)) as this recursion uses stack
	public Node recursiveInsert(Node node, int value) {
		if (node == null)
			return new Node(value);

		if (value < node.value) {
			node.left = recursiveInsert(node.left, value);
		} else
			node.right = recursiveInsert(node.right, value);

		return node;
	}

	public void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.value + " -> ");
			inorderTraversal(root.right);
		}

	}

	public static void main(String[] args) {

		Node root = null;
		TreeInsertion tree = new TreeInsertion();
		root = tree.iterativeInsert(root, 4);
		tree.iterativeInsert(root, 3);
		tree.iterativeInsert(root, 14);
		tree.iterativeInsert(root, 12);

		tree.inorderTraversal(root);
		System.out.println();

		Node root2 = null;
		root2 = tree.recursiveInsert(root2, 4);
		tree.recursiveInsert(root2, 3);
		tree.recursiveInsert(root2, 14);
		tree.recursiveInsert(root2, 12);

		tree.inorderTraversal(root2);

	}

}
