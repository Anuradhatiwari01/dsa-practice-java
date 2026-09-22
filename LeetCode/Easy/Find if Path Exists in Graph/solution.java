class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int startNode = source;
        boolean[] visited = new boolean[n];
        dfs(adj, startNode, destination, visited);
        if(visited[destination]){
            return true;
        }
        else{
            return false;
        }
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int i, int destination, boolean[]visited){
        visited[i] = true;
        for(int v : adj.get(i)){
            if(!visited[v]){
                dfs(adj, v, destination, visited);
            }
        }
    }
}