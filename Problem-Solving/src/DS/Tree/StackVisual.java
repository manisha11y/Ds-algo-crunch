package DS.Tree;

public class StackVisual {
	
	public void recursiveInorder(Node node) {
		if(node != null)
			 {
			System.out.printf("\n add Node %d", node.value);
			recursiveInorder(node.left);
			System.out.printf("\n Remove and print  %d",node.value);
			recursiveInorder(node.right);
		}
		
	}

}
