package in.ineuron.questions;

import java.util.Arrays;

/*
 Q4.**You are given a large integer represented as an integer array digits, where each digits[i] is the 
 	  ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right 
 	  order. The large integer does not contain any leading 0's.
	  Increment the large integer by one and return the resulting array of digits.
 	  **Example 1:**
	  Input: digits = [1,2,3]
	  Output: [1,2,4]
 	  **Explanation:** The array represents the integer 123.
	  Incrementing by one gives 123 + 1 = 124.
	  Thus, the result should be [1,2,4].
 */
public class Question04 {
	public int[] addOne(int[] digits) {
		int carry = 1;

		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += carry;
			carry = digits[i] / 10;  
			digits[i] %= 10;
		}

		if (carry != 0) {
			int[] result = new int[digits.length + 1];
			result[0] = carry;
			for (int i = 0; i < digits.length; i++) {
				result[i + 1] = digits[i];
			}
			return result;
		} else {
			return digits;
		}
	}

	public static void main(String[] args) {
		Question04 q4 = new Question04();
		int[] res = q4.addOne(new int[] {1,2,9});
		System.out.println(Arrays.toString(res));
	}

}