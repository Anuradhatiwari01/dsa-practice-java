
import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(n, costs, dp);
    }

    private int solve(int i, int[] cost, int[] dp) {

        if (i == 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        for (int j = 1; j <= 3; j++) {

            if (i - j >= 0) {
                int prevCost = solve(i - j, cost, dp);

                int currCost = prevCost + cost[i - 1] + j * j;

                minCost = Math.min(minCost, currCost);
            }
        }

        return dp[i] = minCost;
    }
}
