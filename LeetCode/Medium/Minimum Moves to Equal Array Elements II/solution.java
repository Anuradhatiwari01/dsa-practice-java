class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        
        int count = 0;
        for(int n : nums){
            count += Math.abs(median - n);
        }
        
        return count;
    }
}