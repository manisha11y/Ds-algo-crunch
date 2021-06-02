package DS.Tree;
import DS.Tree.*;
public class test {

	public static void main(String[] args) {
		TreeInsertion tree = new  TreeInsertion();
		TreeTraversal traverse = new TreeTraversal();
		StackVisual v = new StackVisual();
		
		Node root = null;
		root = tree.iterativeInsert(root, 4);
		tree.iterativeInsert(root, 2);
		tree.iterativeInsert(root, 1);
		tree.iterativeInsert(root, 3);	
		tree.iterativeInsert(root, 7);
		tree.iterativeInsert(root, 6);
		tree.iterativeInsert(root, 8);
		tree.iterativeInsert(root, 5);
		tree.iterativeInsert(root, 9);
		
//		v.recursiveInorder(root);
		System.out.println("\nInorder : ");
		traverse.recursiveInorder(root);
		System.out.println("\nIterative In Order Traversal : ");
		traverse.iterativeInorder(root);
		System.out.println("\n#####################################");
//		System.out.println("\nLevel Order Traversal : ");
//		traverse.levelOrderTraversal(root);
		System.out.print("\nPreorder : ");
		traverse.recursivePreorder(root);
		System.out.println("\nIterative Pre Order Traversal : ");
		traverse.iterativePreorder(root);
		System.out.println("\n######################################");

		System.out.print("\n\n Postorder : ");
		traverse.recursivePostorder(root);
		System.out.println("\nIterative Post Order Traversal : ");
		traverse.iterativePostorder(root);

		
		

	}

}
