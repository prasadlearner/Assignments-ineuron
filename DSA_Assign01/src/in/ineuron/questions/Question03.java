package in.ineuron.questions;

/*
 Q3.** Given a sorted array of distinct integers and a target value, return the index if the 
 	   target is found. If not, return the index where it would be if it were inserted in order.
	You must write an algorithm with O(log n) runtime complexity.
 	**Example 1:**
	Input: nums = [1,3,5,6], target = 5
	Output: 2
 */
public class Question03 {

	public int findTarget(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;
		int index = 0;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == nums[mid]) {
				index = mid;
				break;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else if (target > nums[mid]) {
				low = mid + 1;
			}
		}
		if(low > high) {
			int count = 0;
			for(int i = 0; i<nums.length; i++) {
				if(target > nums[i] ) {
					count++;
				} 
			}
			index = count;
		}
		return index;
	}

	public static void main(String[] args) {
		Question03 q3 = new Question03();
		int index = q3.findTarget(new int[] {1,3,5,6}, 5);
		System.out.println("The index of the target is or wolud be :: "+index);
	}

}
