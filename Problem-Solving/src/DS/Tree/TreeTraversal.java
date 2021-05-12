package DS.Tree;

/**
 * 
 * @author manisha8
 * This class contains all the tree traversals, Both recursive and iterative approaches
 * 
 * 1. Depth First Search
 * *** Inorder, preorder, postorder traversal (iterative using stack)
 * *** Inorder, preorder, postorder traversal (recursive uses stack internally)
 * 
 * 2.Breadth First Search/Level Order Traversal 
 * *** iterative using Queue
 * *** recursive uses stack internally
 * 
 */
public class TreeTraversal {	
	
	// time: O(n) as we traverse each node once, space: O(log(n)) worst: O(n) in case of skew tree 
	public void recursiveInorder(Node node) {
		if(node == null)
			return;
		else {
			recursiveInorder(node.left);
			System.out.print(" -> "+node.value);
			recursiveInorder(node.right);
		}
		
	}
	
	public void recursivePreorder(Node node) {
		if(node == null)
			return;
		else {
			System.out.print(" -> "+node.value);
			recursivePreorder(node.left);
			recursivePreorder(node.right);
		}
		
	}
	
	public void recursivePostorder(Node node) {
		if(node == null)
			return;
		else {
			recursivePostorder(node.left);
			recursivePostorder(node.right);
			System.out.print(" -> " +node.value);
		}
		
	}
	
	public static void main(String[] args) {
		

	}

}
