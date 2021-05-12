
import java.util.*;

class test {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  
	public void computeSum(BinaryTree node, Integer currentSum, ArrayList<Integer> result){
		if(node == null){			
			return;
		}
		else{
			  computeSum(node.left, node.value + currentSum, result);
				result.add(currentSum);
			  computeSum(node.right, node.value + currentSum, result);
			
		}
		
	}
	
  public static List<Integer> branchSums(BinaryTree root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
	
    return result;
  }
}


