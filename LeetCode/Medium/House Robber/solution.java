class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
    }
    public int solve(int idx, int[] nums, int[]dp){
        if(idx >= nums.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int steal = nums[idx] + solve(idx+2, nums, dp);
        int skip = solve(idx+1, nums, dp);

        return dp[idx] = Math.max(steal, skip);
    }
}