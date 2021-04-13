package BT_Traversal;
class Node{
	
	int value;
	Node left, right;
	
	public Node(int value) {
		this.value = value;
		left = right = null;
	}
}

class BinaryTree{
	
	Node root;
	
	BinaryTree() {
		root = null;
	}
	
    BinaryTree(int value) {
		root = new Node(value);
	}
	
	public void traverseInorder(Node node) {
		if(node != null) {
			traverseInorder(node.left);
			System.out.print("->" + node.value);
			traverseInorder(node.right);
		}
	}
	
	public void traversePreorder(Node node) {
		if(node != null) {
			System.out.print("->" + node.value);
			traversePreorder(node.left);
			traversePreorder(node.right);
		}

	}
	
	public void traversePostOrder(Node node) {
		if(node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print("->" + node.value);

		}

	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.right.right = new Node(5);
		
		System.out.print("Preorder Traversal ___");
		bt.traversePreorder(bt.root);
		System.out.print("\nInorder Traversal ___");
		bt.traverseInorder(bt.root);
		System.out.print("\nPostorder Traversal ___");
		bt.traversePostOrder(bt.root);
		
	}
	
}
