class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;

        int maxone = Integer.MIN_VALUE;

        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 0){
                count++;
            }
            if(count > k){
                while(count > k){
                    if(nums[i] == 0){
                        count--;
                    }
                    i++;
                }
            }
            maxone = Math.max(maxone, j-i+1);

        }
        return maxone;
    }
}