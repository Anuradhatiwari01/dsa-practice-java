class Solution {
    public int closedIsland(int[][] grid) {
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        int count = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0){
                    ArrayDeque<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{r,c});

                    grid[r][c] = 1;

                    boolean isClosed = true;

                    while(!queue.isEmpty()){
                        int[] node = queue.poll();

                        int cr = node[0];
                        int cc = node[1];

                        if(cr == 0 || cr == grid.length-1 || cc ==0 || cc == grid[0].length-1){
                            isClosed = false;
                        }

                        for(int[]d : directions){
                            int nr = cr + d[0];
                            int nc = cc + d[1];

                            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 0){

                                grid[nr][nc] = 1;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    if(isClosed){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}