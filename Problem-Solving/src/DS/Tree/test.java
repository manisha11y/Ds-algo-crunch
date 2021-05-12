package DS.Tree;

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
//		tree.iterativeInsert(root, 8);
//		tree.iterativeInsert(root, 5);
//		tree.iterativeInsert(root, 9);
		
		v.recursiveInorder(root);
		System.out.println("\nInorder : ");
		traverse.recursiveInorder(root);
//		System.out.print("\nPreorder : ");
//		traverse.recursivePreorder(root);
//		System.out.print("\nPostorder : ");
//		traverse.recursivePostorder(root);
		
		

	}

}
