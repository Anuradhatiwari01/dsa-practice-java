class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[V];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(adj, visited, stack, i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,ArrayDeque<Integer> stack, int node){
        visited[node] = true;
        
        
        for(int v : adj.get(node)){
            if(!visited[v]){
                dfs(adj, visited, stack, v);
            }
        }
        stack.push(node);
    }
}




















