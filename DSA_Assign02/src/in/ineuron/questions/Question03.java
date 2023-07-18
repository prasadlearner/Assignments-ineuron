package in.ineuron.questions;

import java.util.HashMap;
import java.util.Map;

/*

💡 Question 3
	We define a harmonious array as an array where the difference between its maximum value
	and its minimum value is exactly 1.

	Given an integer array nums, return the length of its longest harmonious subsequence
	among all its possible subsequences.

	A subsequence of an array is a sequence that can be derived from the array by deleting 
	some or no elements without changing the order of the remaining elements.

	Example 1:
	Input: nums = [1,3,2,2,5,2,3,7]
	Output: 5

	Explanation: The longest harmonious subsequence is [3,2,2,2,3].
	
 */
public class Question03 {

	public static int maxLengthOfSubArr(int[] nums) {
		
		Map<Integer, Integer> myMap  = new HashMap<Integer, Integer>();
		
		for(int num: nums) {
			if(!myMap.containsKey(num)) {
				myMap.put(num, 1);
			} else {
				myMap.put(num, myMap.get(num)+1);
			}
		}
		
		int maxLength = 0;
		System.out.println(myMap.keySet());
		for(int num: myMap.keySet()) {
			//1, 2, 3, 5, 7
			if(myMap.containsKey(num+1)) {
				maxLength = Math.max(maxLength, myMap.get(num)+myMap.get(num+1));//4 // 5
			}
		}
		
		return maxLength;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,3,2,2,5,2,3,7};
		int maxLength = maxLengthOfSubArr(nums);
		System.out.println("Max length of sub array is :: "+maxLength);
	}

}
