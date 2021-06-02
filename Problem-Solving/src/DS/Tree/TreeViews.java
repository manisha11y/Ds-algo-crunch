package DS.Tree;
 import  DS.Tree.*;
import java.util.*;

/*
 * LeftView Of Binary Tree
 * Bottom View of Binary Tree
 * Top View of Binary Tree 
 * 
 */

class Tree{
	
	int maxLevel = 0;

	//level order traversal
	public void BFSTraversal(Node root){
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node currNode = queue.poll(); // poll will remove and return front element in the queue
			System.out.print(" -> " +currNode.value );
			
			if(currNode.left!=null)
				queue.add(currNode.left);
			if(currNode.right!=null)
				queue.add(currNode.right);
		}

	}
	
	/*
	 * ITERATIVE APPROACH - time O(n) and space O(n) (Acc to me space: O(Queue + result): 
	 * (Queue)max number of node at a level + (result) max height of a tree)
	 * The approach is to use LEVEL ORDER TRAVERSAL and print the first(left most) node of each level
	 * By maintaining the size of queue, only pick first element of each level
				  		1
			          /   \		
					 2	   6
			        / \		\	
				   3   4	 9
				        \
						 5
		Queue : 1 		size: 1 result: 1
		Queue : 2,6 	size: 2 result: 1,2
		Queue : 3,4,9 	size: 3 result: 1,2,3
		Queue : 5 		size: 1 result: 1,2,3,5
		
	* Note: removal of previous level nodes and adding new level nodes is happening in while loop,
	* in order to remove the level nodes after adding left most node in the result	
	* (for eg: 2,6 removed and after adding 2 in result and 3,4,9 will be added as next level node)
	* and add new level node in the queue before it loop again to calculate the size of the queue.	 
	*/
	public ArrayList<Integer> treeLeftView(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		// return if the tree is empty
		if (root == null) {
			return result;
		}
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			// adding front(Left most) element from the queue to result
			result.add(queue.peek().value);
			// Let it traverse the rest of the node at existing level without adding in the
			// result and prepare the other nodes in the queue for next level
			while (size-- > 0) {
				Node currNode = queue.poll();
				if (currNode.left != null)
					queue.add(currNode.left);
				if (currNode.right != null)
					queue.add(currNode.right);

			}
		}
		return result;
	}
	
	/*
	 * RECURSIVE APPROACH- PREORDER TRAVERSAL time o(n) space: o(h) for recursive call , "h" height of tree
	 * 
	 * The approach is to use Preorder traversal and keep track of level and maxLevel visited
	 * if currLevel is less then maxLevel visited than add node value to the result 
	 *                  1
			          /   \		
					 2	   6
			        / \		\	
				   3   4	 9
				        \
						 5
		call(1) 		  	currLevel: 1 maxLevel: 0->1 result: [1], max <currLevel i.e update maxLevel
		call(2)           	currLevel: 2 maxLevel: 1->2 result: [1,2], max <currLevel i.e update maxLevel
		call(3)         	currLevel: 3 maxLevel: 2->3 result: [1,2,3] maxLevel< currLevel, update maxLevel
		return from call(3)	currLevel: 2(thats when it was at 2) maxLevel: 3 result: [1,2,3] 
		call(4)           	currLevel: 3 maxLevel: 3 result: [1,2,3] avoid 4 as its level visited
		call(5),return     	currLevel: 4 maxLevel: 3->4 result: [1,2,3,5] maxLevel< currLevel, update maxLevel
		call(6),3*returns   currLevel: 1(thats when it was at 1) maxLevel: 4 result: [1,2,3,5] avoid 6 as its level visited
		call(9),return      currLevel: 2 maxLevel: 4 result: [3] maxLevel< currLevel, update maxLevel avoid 9 as its level visited

		
	 */
	public void recursiveLeftView(Node node, int currLevel, ArrayList<Integer> result){
		if(node == null) {
			return;
		}
		
		if(maxLevel < currLevel) {
			result.add(node.value);
			maxLevel = currLevel;
		}
		recursiveLeftView(node.left, currLevel+1, result );
		recursiveLeftView(node.right, currLevel+1, result );	
		
	}
	
	/*
	 * RESURSIVE APPROACH : A Slight change in ordering of Left View 
	 * recursive calls thats it
	 */
	public void recursiveRightView(Node node, int currLevel, ArrayList<Integer> result){
		if(node == null) {
			return;
		}
		
		if(maxLevel < currLevel) {
			result.add(node.value);
			maxLevel = currLevel;
		}
		recursiveLeftView(node.right, currLevel+1, result );
		recursiveLeftView(node.left, currLevel+1, result );	
		
	}
	
	/*
	 * RECURSIVE BOTTOM VIEW - LEVEL ORDER TRAVERSAL 
	 * The approach is during the level order traversal keep calculating and updating the horizontal
	 * distance of the node form root (Adding extra variable for hd in NODE class), formula is for left
	 * child hd: parentHD - 1 and right child hd: parentHD - 1.
	 * 
	 * At each traversal while we pop front ele from the queue, we will add the hd as key and node.value as
	 * a value in TreeMap(As it is best to auto sort key- which is required in this, 
	 * to print result in sequence) 
	 *  				1
			          /   \		
					 2	   6
			        / \		\	
				   3   4	 9
				        \
						 5
	*	Queue: [1,hd:0]					TreeMap: {} 						 parentHd :0
	*	Queue: [pop]					TreeMap: {0=1} 						 parentHd :0 pop queue, add in treeMap and update parentHd
	*	Queue: [[2,-1], [6,1]]			TreeMap: {0=1} 						 parentHd :0 add another level
	*	Queue: [pop,[6,1],[3,-2],[4,0]]	TreeMap: {-1=2}{0=1} 				 parentHd :-1 pop queue, add in treeMap and update parentHd
	*	Queue: [pop,[3,-2],[4,0],[9,2]]	TreeMap: {-1=2}{0=1}{1=6}			 parentHd :1  ""
	*   Queue: [pop,[4,0],[9,2]]		TreeMap: {-2=3}{-1=2}{0=1}{1=6} 	 parentHd :-2 pop queue, add in treeMap and update parentHd
	*	Queue: [pop,[9,2],[5,1]]		TreeMap: {-2=3}{-1=2}{0=4}{1=6}  	 parentHd :0 Note:Overwrite 0Key value in treeMap
	*	Queue: [pop,[5,1]]				TreeMap: {-2=3}{-1=2}{0=4}{1=6}{2=9} parentHd :2 
	*	Queue: [pop]					TreeMap: {-1=2}{-2=3}{0=4}{1=5}{2=9} parentHd :1 
	*	
	* And the final result is: 2,3,4,5,9		 
	 */
	public ArrayList<Integer> BottomView(Node node) {
		
			Queue<Node> queue = new ArrayDeque<Node>();
			TreeMap<Integer, Integer> nodeMap = new TreeMap<Integer, Integer>();
			ArrayList<Integer> result = new ArrayList<Integer>();
			int parenthd = 0;
			
			// return if the tree is empty
			if (node == null) {
				return result;
			}
			node.horizontalDistance = 0;
			queue.add(node);	
			

			while (!queue.isEmpty()) {
				Node currNode = queue.poll();				
				nodeMap.put(currNode.horizontalDistance, currNode.value);
				//get parent hd in advance to update child distance further
				parenthd = currNode.horizontalDistance;
				if (currNode.left != null) {
					currNode.left.horizontalDistance= parenthd-1;
					queue.add(currNode.left);					
				}
					
				if (currNode.right != null) {
					currNode.right.horizontalDistance = parenthd+1;
					queue.add(currNode.right);
				}

			}
			
			for(Integer key: nodeMap.keySet()) {
				result.add(nodeMap.get(key));
			}
			return result;
		
		
	}
	
	/*Function to print the leaf nodes
	 * public void recursivLeafNode(Node node) {
		if(node == null) {
			return;
		}
		if(node.left == null && node.right == null) {
			System.out.print(" _> " + node.value);
			return;
		}
		else {
			recursiveBottomView(node.left);
			recursiveBottomView(node.right);;
		}
	}
	 */
	
	public void print(String msg, ArrayList<Integer> list) {
		System.out.print(msg + " View of binary Tree : ");
		for(Integer item: list)
			System.out.print(" -> " +  item);
	}
	

}

public class TreeViews {
	
	/*
	 print the left view of the tree
	 		1
          /   \		
		 2	   6
        / \		\	
	   3   4	 9
	        \
			 5
	 Left View : 1,2,3,5
	*/

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.right.right= new Node(9);
		
//		//another input
//		Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.right = new Node(4);
//        root.right.left = new Node(5);
//        root.right.right = new Node(6);
//        root.right.left.left = new Node(7);
//        root.right.left.right = new Node(8);

		Tree tree = new Tree();
		System.out.print("Level order traversal : ");		
		tree.BFSTraversal(root);
		
		ArrayList<Integer> list = tree.treeLeftView(root);
		tree.print("\nLeft" , list);
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		tree.recursiveLeftView(root, 1, list2);
		tree.print("\nRecursive Left",list2);
		
		tree.maxLevel=0;
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		tree.recursiveRightView(root, 1, list3);
		tree.print("\nRecursive Right",list3);
		
		tree.print("\nBottom", tree.BottomView(root));
		

		

	}

}

