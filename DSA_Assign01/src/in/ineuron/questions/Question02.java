package in.ineuron.questions;

import java.util.ArrayList;
import java.util.List;

/*
 Q2.** Given an integer array nums and an integer val, remove all occurrences of val in nums 
 	   in-place. The order of the elements may be changed. Then return the number of elements in
 	   nums which are not equal to val.
	   Consider the number of elements in nums which are not equal to val be k, to get accepted, 
	   you need to do the following things:
	   - Change the array nums such that the first k elements of nums contain the elements which 
	   are not equal to val. The remaining elements of nums are not important as well as the size 
	   of nums.
	   - Return k.
 	**Example :**
	Input: nums = [3,2,2,3], val = 3
	Output: 2, nums = [2,2,_*,_*]
 */
public class Question02 {

	public List<Integer> removeNumberFromArray(int[] nums, int val) {

		List<Integer> k = new ArrayList<>();
		for (int i = 0; i < nums.length - i; i++) {
			if (nums[i] == 3) {
				int temp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = temp;
			}
		}
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == 3) {
				nums[j] = 0;
				k.add(nums[j]);
			} else {
				k.add(nums[j]);
			}
		}

		return k;
	}

	public static void main(String[] args) {
		Question02 q2 = new Question02();
		List<Integer> k = q2.removeNumberFromArray(new int[] { 3, 2, 2, 3 }, 3);

		k.forEach(System.out::println);


	}

}
