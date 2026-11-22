class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(s, 0, n-1, dp);
    }
    public int solve(String s, int i, int j, int[][]dp){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = solve(s, i+1, j-1, dp);
        }
        else{
            int left = solve(s, i, j-1, dp);
            int right = solve(s, i+1, j, dp);

            dp[i][j] = 1 + Math.min(left, right);
        }
        return dp[i][j];
    }
}