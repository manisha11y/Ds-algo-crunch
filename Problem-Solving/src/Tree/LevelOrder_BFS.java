package BFS;

// program to implement level order traversal in Binary Tree
class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		left = right = null;
	}
}

class BinaryTree{
	
	Node root;
	
	BinaryTree(){
		root = null;
	}
	
	BinaryTree(int data){
		root = new Node(data);
	}
	
	public Node createTree() {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(2);
		bt.root.left = new Node(1);
		bt.root.right = new Node(14);
		bt.root.left.right = new Node(60);
		bt.root.right.left = new Node(12);
		bt.root.right.right = new Node(50);
		return bt.root;
	}
	
	public void traverseInorder(Node node) {
		if(node != null) {
			traverseInorder(node.left);
			System.out.print(" -> " + node.data);
			traverseInorder(node.right);
		}
	}
	
	
	
}


public class LevelOrder_BFS {
	
	public static void levelOrderTraversal(Node node) {
		 
			if(node.left!= null) {
				System.out.print(" -> " + node.left.data);
			}
			else
				System.out.print(" -> " + "null");
			
			if(node.right!= null) {
				System.out.print(" -> " + node.right.data);
			}
			else
				System.out.print(" -> " + "null");
			
			if(node.left!= null) {
				levelOrderTraversal(node.left);
			}
			
			if(node.right!= null) {
				levelOrderTraversal(node.right);
			}
			
	
	}
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		Node root = tree.createTree();
		System.out.print("Inorder Traversal :  ");
		tree.traverseInorder(root);
		System.out.print("\nLevel Order Traversal :  ");
		
		if(root!= null) {
			System.out.print(" -> " + root.data);
			levelOrderTraversal(root);
		}

	}

}
