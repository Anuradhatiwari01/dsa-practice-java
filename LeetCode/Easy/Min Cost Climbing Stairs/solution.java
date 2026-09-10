class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);

        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }
    public int solve(int idx, int[]cost, int[]dp){
        if(idx >= cost.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }


        int cost1 = cost[idx] + solve(idx+1, cost, dp);
        int cost2 = cost[idx] + solve(idx+2, cost, dp);

        return dp[idx] = Math.min(cost1, cost2);
    }
}