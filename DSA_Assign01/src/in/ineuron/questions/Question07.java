package in.ineuron.questions;

import java.util.Arrays;

/*
 Q7.** 	Given an integer array nums, move all 0's to the end of it while maintaining the 
 		relative order of the nonzero elements.
		Note that you must do this in-place without making a copy of the array.
 		**Example 1:**
		Input: nums = [0,1,0,3,12]
		Output: [1,3,12,0,0]
 */
public class Question07 {
	public int[] sendZerosAtEnd(int[] nums) {

		int index = 0;

		for(int num : nums) {
			if(num != 0) {
				nums[index] = num;
				index++;
			}
		}

		while(index < nums.length) {
			nums[index] = 0;
			index++;
		}


		return nums;

	}

	public static void main(String[] args) {
		Question07 q7 = new Question07();
		int[] nums = q7.sendZerosAtEnd(new int[] {0,1,0,3,12});
		System.out.println(Arrays.toString(nums));

	}

}