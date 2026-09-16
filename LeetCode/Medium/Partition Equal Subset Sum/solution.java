class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }
        
        int target = sum/2;

        Boolean[][] dp = new Boolean[target+1][n];
        return solve(nums, target, 0, dp);
    }
    public boolean solve(int[]nums, int target, int idx, Boolean[][] dp){
        if(target < 0){
            return false;
        }if(idx == nums.length){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(dp[target][idx] != null){
            return dp[target][idx];
        }

        boolean take = solve(nums, target-nums[idx], idx+1, dp);
        boolean skip = solve(nums, target, idx+1, dp);

        dp[target][idx] =  take || skip;

        return dp[target][idx];
            

    }
}