package in.ineuron.questions;

class Solution3 {
    public int missingNumber(int[] nums) {
        int expected_sum = 0;
        int sum = 0;
        for(int i =0;i<=nums.length;i++){
            expected_sum += i;
        }
        for(int j =0;j<nums.length;j++){
            sum += nums[j];
        }
        return expected_sum - sum;
    }
}
