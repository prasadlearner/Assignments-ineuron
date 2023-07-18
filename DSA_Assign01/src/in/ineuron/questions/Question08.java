package in.ineuron.questions;

import java.util.Arrays;
import java.util.HashSet;

/*
 Q7.** 	You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, 
 		due to some error, one of the numbers in s got duplicated to another number in the set, 
 		which results in repetition of one number and loss of another number.
		You are given an integer array nums representing the data status of this set after the error.
		Find the number that occurs twice and the number that is missing and return them in the 
		form of an array.
 		**Example 1:**
		Input: nums = [1,2,2,4]
		Output: [2,3]
 */
public class Question08 {
	public int[] findMissingNumber(int[] nums) {
		int n = nums.length;
		HashSet<Integer> hs = new HashSet<>();

		int duplicate = -1;
		int actualSum = 0;

		for (int num : nums) {
			if (hs.contains(num)) {
				duplicate = num;
			}

			hs.add(num);
			actualSum += num;
		}

		int expectedSum = n * (n + 1) / 2;
		int missing = expectedSum - actualSum + duplicate;

		return new int[] {duplicate, missing};

	}

	public static void main(String[] args) {
		Question08 q8 = new Question08();
		int[] result = q8.findMissingNumber(new int[] { 1, 2, 2, 4 });
		System.out.println("Duplicate number is :: " + result[0]);
		System.out.println("Missing number is :: " + result[1]);

	}

}
