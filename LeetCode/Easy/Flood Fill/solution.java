class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(color == original){
            return image;
        }
        solve(image, sr, sc, color, original);
        return image;        
    }
    public void solve(int[][]grid, int r, int c, int color, int original){
        if(r >= grid.length || c >= grid[0].length|| r < 0 || c < 0){
            return;
        }
        if(grid[r][c] != original){
            return;
        }
        grid[r][c] = color;
        solve(grid, r, c-1 , color, original);
        solve(grid, r, c+1 , color, original);
        solve(grid, r+1, c , color, original);
        solve(grid, r-1, c , color, original); 
    }
}