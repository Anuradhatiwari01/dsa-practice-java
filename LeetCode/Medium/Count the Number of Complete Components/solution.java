class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
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
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            ArrayList<Integer> component = new ArrayList<>();
            if(!visited[i]){
                dfs(adj, visited, i, component);

                int k = component.size();
                boolean isComplete = true;
                for(int c : component){
                    if(adj.get(c).size() != k-1){
                        isComplete = false;
                    }
                }
                if(isComplete){
                    count++;
                }   
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, ArrayList<Integer> component){

        visited[node] = true;
        component.add(node);

        for(int v : adj.get(node)){
            if(!visited[v]){
                dfs(adj, visited, v, component);
            }
        }
    }
}