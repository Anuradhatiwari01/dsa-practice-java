class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findUniquePaths(0, 0, m, n, obstacleGrid, dp);
    }
    public int findUniquePaths(int r, int c, int m, int n, int[][] grid, int[][] dp){
        if(r >= m || c >= n){
            return 0;
        }
        if(grid[r][c] == 1){
            return 0;
        }
        if(r == m-1 && c == n-1){
            return 1;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        dp[r][c] = findUniquePaths(r+1, c, m, n, grid, dp) + findUniquePaths(r, c+1, m , n, grid, dp);

        return dp[r][c];

    }
}