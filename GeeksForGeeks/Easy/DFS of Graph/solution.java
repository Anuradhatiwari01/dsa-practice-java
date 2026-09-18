class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int node = 0;
        
        solve(adj, visited, res, node);
        
        return res;
        
    }
    
    public void solve(ArrayList<ArrayList<Integer>> adj, boolean[]visited, ArrayList<Integer>res, int node){
        if(visited[node]){
            return;
        }
        
        visited[node] = true;
        res.add(node);
        
        for(int neigh : adj.get(node)){
            solve(adj, visited, res, neigh);
        }
    }
}