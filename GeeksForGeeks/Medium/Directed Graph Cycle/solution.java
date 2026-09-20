class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
       for(int i = 0; i < V; i++){
           adj.add(new ArrayList<>());
       }
       
        for(int[]edge : edges){
           int u = edge[0];
           int v = edge[1];
           
           adj.get(u).add(v);
        }
        boolean[] inRecursion = new boolean[V];
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(adj, inRecursion, visited, i)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] inRecursion, boolean[] visited, int node){
        
        visited[node] = true;
        inRecursion[node] = true;
        
        for(int v : adj.get(node)){
            if(!visited[v]){
                if(dfs(adj, inRecursion, visited, v)){
                    return true;
                }
            }
            else if(inRecursion[v]){
                return true;
            }
        }
        inRecursion[node] = false;
        return false;
    }
}








