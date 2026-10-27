class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        String[][] res = new String[m][n];
        if(m == n){
            for(int r = 0; r < m; r ++){
                for(int c = 0; c < n; c++){
                    if(res[r][c] == ".")continue;
                    else if(r  == c){
                        res[r][c] = ".";
                        if(c+1 <= n-1){
                            res[r][c+1] = ".";
                        } 
                    }
                    else{
                        res[r][c] = "#";
                    }
                    
                }
            }
        }
        if(m == 1){
            for(int c = 0; c < n; c++){
                res[0][c] = ".";
            }
        }
        if( m != n){
            for(int r = 0; r < m; r ++){
                for(int c = 0; c < n; c++){
                    if(r == 0 || c == n-1){
                        res[r][c] = ".";
                    }
                    else{
                        res[r][c] = "#";
                    }
                }
            }
            
        }
        
        for(int r = 0; r < m; r++){
            String ans = "";
            for(int c = 0; c < n; c++){
                ans += res[r][c];
            }
            grid[r] = ans;
        }
        return grid;
    }
}