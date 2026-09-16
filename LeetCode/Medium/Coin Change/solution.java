class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(coins, amount, 0, dp);

        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return ans;
        }
    }

    public int solve(int[] coins, int amount, int idx, int[][]dp){
        if(amount == 0){
            return 0;
        }
        if(amount < 0 || idx == coins.length ){
            return Integer.MAX_VALUE;
        }
        if(dp[amount][idx] != -1){
            return dp[amount][idx];
        }

        int take = solve(coins, amount-coins[idx], idx, dp);
        if(take != Integer.MAX_VALUE){
            take  = 1 + take;
        }
        int skip = solve(coins, amount, idx+1, dp);

        dp[amount][idx] = Math.min(take, skip);
        return dp[amount][idx];
    }
} 