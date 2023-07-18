
package in.ineuron.questions;

import java.util.HashSet;

/*
 Q6.** 	Given an integer array nums, return true if any value appears at least twice in the array, 
 		and return false if every element is distinct.
 		**Example 1:**
		Input: nums = [1,2,3,1]
		Output: true
 */
public class Question06 {
	public boolean duplicateElements(int[] nums) {

		HashSet<Integer> hs = new HashSet<>();
		boolean flag = false;

		for (int num : nums) {
			if (hs.contains(num)) {
				flag = true;
			}
			hs.add(num);
		}

		return flag;

	}

	public static void main(String[] args) {
		Question06 q6 = new Question06();
		boolean isDublicatesPresents = q6.duplicateElements(new int[] { 1,2,3,1 });
		System.out.println("Dublicates present in the array :: " + isDublicatesPresents);
	}

}