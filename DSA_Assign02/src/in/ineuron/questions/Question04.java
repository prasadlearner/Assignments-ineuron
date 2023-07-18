package in.ineuron.questions;

class Solution4 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int m = flowerbed.length;

        if(n > m/2 +1){
            return false;
        }

        int idx = 0;

        while(n > 0 && idx < m){
            if(idx + 1 < m && flowerbed[idx + 1] == 1){
                idx++;
            } else if(flowerbed[idx] == 0){
                n--;
            }
            idx +=2;
        }

        return n == 0;
    }
}
