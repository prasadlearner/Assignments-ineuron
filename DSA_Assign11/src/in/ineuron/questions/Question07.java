package in.ineuron.questions;

class Solution7 {
    public int[] searchRange(int[] nums, int target) {
	         int[] result = new int[2];
        result[0] = searchFirst(nums, target);
        result[1] = searchLast(nums, target);

        return result;
    }

    private int searchFirst(int[] nums, int target){
        int left = 0; // left index
        int right = nums.length - 1; 
        int index = -1; 

        while(left <= right){

            int mid = left + (right - left) / 2; 

            if(nums[mid] == target){
                index = mid; // update index of the first occurrence
                right = mid - 1; 
            }

            else if(nums[mid] < target){
                left = mid + 1; 
            }
            else{
                right = mid - 1;
            }
        }

        return index;
    }

    // binary search to find the last occurrence of the target
    private int searchLast(int[] nums, int target){
        int left = 0; 
        int right = nums.length - 1; 
        int index = -1;

        while(left <= right){

            int mid = left + (right - left) / 2; 

            if(nums[mid] == target){
                index = mid; 
                left = mid + 1;
            }

            else if(nums[mid] < target){
                left = mid + 1; 
            }
            else{
                right = mid - 1; 
            }
        }

        return index;
	    }

}