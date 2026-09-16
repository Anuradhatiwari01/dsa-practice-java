class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        
        int[][] dp = new int[m+1][n+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(text1, text2, m, n, 0, 0, dp);
    }

    public int solve(String t, String s, int m, int n, int i, int j, int[][] dp){
        if(i > m || j > n){
            return 0;
        }
        if(i == m || j == n){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = 1 + solve(t, s, m, n, i+1, j+1, dp);
        }
        else{
            dp[i][j] = Math.max(solve(t, s, m, n, i+1, j, dp), solve(t,s,m,n,i, j+1, dp));
        }
        return dp[i][j];
    }
}