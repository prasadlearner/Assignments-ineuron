package in.ineuron.questions;

import java.util.HashSet;

class Solution4 {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();

        for(int num: nums){
            if(!hs.contains(num)){
                hs.add(num);
            } else{
                return num;
            }
        }
        return -1;
    }
}