class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }    
        
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(!dfs(adj, color, i, 1)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] color, int curr, int currColor){
        color[curr] = currColor;
        
        for(int v : adj.get(curr)){
            if(color[v] == color[curr]){
                return false;
            }
            else if(color[v] == -1){
                if(currColor == 1){
                    if(!dfs(adj, color, v,0)){
                        return false;
                    }
                }
                else{
                    if(!dfs(adj, color, v, 1)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
















