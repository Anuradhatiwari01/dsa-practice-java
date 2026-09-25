class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;
        int minute = 0;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 1){
                    fresh++;
                }
                else if(grid[row][col] == 2){
                    queue.offer(new int[]{row, col});
                }
            }
        }

        while(!queue.isEmpty() &&  fresh > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];

                for(int[]d : directions){
                    int nr = r+d[0];
                    int nc = c+d[1];

                    if(nr < n && nc < m && nr >= 0 && nc >= 0){
                        if(grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            fresh--;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            minute++;
        }
        if(fresh == 0){
            return minute;
        }
        else{
            return -1;
        }
        
    }
}