package in.ineuron.questions;

import java.util.ArrayList;
import java.util.List;

/*
 Q1.** Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	You can return the answer in any order.
 **Example:**
	Input: nums = [2,7,11,15], target = 9
	Output0 [0,1]
	Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1]
 */
public class Question01 {

	public List<List<Integer>> twoSumII(int[] nums) {
		int lo = 0;
		int hi = nums.length-1;
		List<List<Integer>> res = new ArrayList<>();

		while(lo < hi) {
			int sum = nums[lo] + nums[hi];

			if(sum>9) {
				--hi;
			} else if(sum < 9) {
				--lo;
			} else {
				res.add(List.of(lo, hi)); 
				break;
			}
		}

		return res;
	}

	public static void main(String[] args) {

		Question01 q1 = new Question01();

		List<List<Integer>> indices = q1.twoSumII(new int[] {2,7,11,15});
		System.out.print("The indices which elements sum up to given target i.e 9 are :: ");
		indices.forEach(System.out::println);


	}

}
