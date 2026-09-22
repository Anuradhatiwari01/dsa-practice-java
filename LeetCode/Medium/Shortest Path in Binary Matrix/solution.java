class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1){
            return -1;
        }
        int[][] directions = new int[][]{{-1,-1}, {1, 1}, {-1, 1}, {1, -1}, {1, 0}, {-1, 0}, { 0, 1}, {0, -1} };

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        while(!queue.isEmpty()){

            int[] ls = queue.poll();

            int r = ls[0];
            int c = ls[1];
            int dist = ls[2];

            if(r == n-1 && c == n-1){
                return dist;
            }

            for(int[] d : directions){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr >=  grid.length || nc >= grid[0].length || nc < 0 || nr < 0){
                    continue;
                }
                else if(nr == n && nc == n){
                    continue;
                }
                else{
                    if(grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        queue.offer(new int[]{nr, nc, dist+1});
                    }   
                }   
            }
        }
        return -1;
    }
}