package test;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] picked = new int[nums.length];
        createSet(nums, 0, new ArrayList<Integer>(), result, picked);
        return result;
        
    }
    
    public void createSet(int[] nums, int i, List<Integer> ds, List<List<Integer>> result, int[] picked)
    {
        if(i == nums.length){
            result.add(new ArrayList<>(ds));
        }
        else{
            if(picked[i] != nums[i]){ //that means its picked for the position
                ds.add(nums[i]);
                picked[i] = nums[i];
                createSet(nums, i+1, ds, result, picked);
                ds.remove(ds.size()-1);
                
            }            
            createSet(nums, i+1, ds, result, picked);
            
        }
    }


	public static void main(String[] args) {
		
		Solution2 sol = new Solution2();
		sol.subsetsWithDup(new int[]{1,2,2});
	}

}
