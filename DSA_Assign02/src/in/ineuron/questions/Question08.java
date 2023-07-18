package in.ineuron.questions;


class Solution8 {
	 public int smallestRangeI(int[] nums, int k) {
	        int min = nums[0];
	        int max = nums[0];
	        
	        // Find the maximum and minimum element of array
	        for(int i = 1; i < nums.length; ++i) {
	            min = Math.min(nums[i], min);
	            max = Math.max(nums[i], max);
	        }
	        
	        int ans = max - min - 2 * k;
	        
	        return ans > 0 ? ans : 0;
	    }
}
