package DS.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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
 * *** recursive solution - hardly possible
 * 
 */
public class TreeTraversal {	
	
	// time: O(n) as we traverse each node once, 
	//space: O(log(n)) worst: O(n) in case of skew tree 
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
	
	/* Iterative DFS - Inorder, Preorder PostOrder using STACK ds */
	public void iterativeInorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		while(node != null || !stack.isEmpty()) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
				node = stack.pop();
				System.out.print(node.value + " - > " );
				node = node.right;
								
			
		}
	}
	
	public void iterativePreorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		while(node != null || !stack.isEmpty()) {
			while(node != null) {
				System.out.print(node.value + " - > " );
				stack.push(node);
				node = node.left;
			}
				node = stack.pop();				
				node = node.right;								
			
		}
	}
	
	public void iterativePostorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		while(node != null || !stack.isEmpty()) {
			if(node != null) {
				stack.push(node);
				node = node.left;
			}
				
			else if(stack.peek().right == null) {
				System.out.print(stack.peek().value + " - > " );
				node = stack.pop();	
			}
			else node = node.right;
			
		}
	}
		
	// BFS: Iterative approach for level order traversal using queue
	public void levelOrderTraversal(Node node) {
		Queue<Node> queue = new ArrayDeque<Node>();
		Node currNode = node;
		
		int level = 0;
		queue.add(node);
		while(!queue.isEmpty()) {
			currNode = queue.poll();
			System.out.print(currNode.value + " -> ");
			if(queue.isEmpty())
			    level++;
			if(currNode.left != null)
				queue.add(currNode.left);	
			if(currNode.right != null)
				queue.add(currNode.right);
			
		}
		
		System.out.printf("Height of the tree is : %d ", level);
		
		
		
	}
	
	public static void main(String[] args) {
		

	}

}
