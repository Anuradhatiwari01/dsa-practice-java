class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int[]rows : dp){
            Arrays.fill(rows, -1);
        }
        return findMinPathSum(grid, dp, n-1, m-1);
    }

    public int findMinPathSum(int[][]grid, int[][]dp, int i, int j){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        dp[i][j] = grid[i][j] + Math.min(findMinPathSum(grid, dp, i-1, j),
                                    findMinPathSum(grid, dp, i, j-1));

        return dp[i][j];
    }
}