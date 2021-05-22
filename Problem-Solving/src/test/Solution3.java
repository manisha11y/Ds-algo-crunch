package test;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        backtrack(candidates,0, target, new ArrayList<Integer>(), result);
	        return result;
	    }
	    
	    public void backtrack(int[] candidate,int idx, int sum, List<Integer> ds, List<List<Integer>> comb){
	        if(sum < 0){
	            return;
	        }
	        if(sum == 0){
	            comb.add(new ArrayList<>(ds));
	            return;
	        }
	        
	            ds.add(candidate[idx]);
	            backtrack(candidate,idx, sum - candidate[idx],ds, comb);
	            ds.remove(ds.size()-1);
	            ds.add(candidate[idx+1]);
	            backtrack(candidate,idx+1, sum - candidate[idx],ds, comb);

	        
	    
	}
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		sol.combinationSum(new int[]{2,3,6,7}, 7);

	}

}
