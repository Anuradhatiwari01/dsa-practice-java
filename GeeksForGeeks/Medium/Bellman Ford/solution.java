class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        
        ArrayList<Integer> result = new ArrayList<>();
        int INF = 100000000;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        
        dist[src] = 0;
        
        for(int i = 1; i < V; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(dist[u] != INF && dist[u]+w < dist[v]){
                    dist[v] = dist[u]+w;
                }
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(dist[u] != INF && dist[u]+w < dist[v]){
                result.add(-1);
                return result;
            }
        }
        
        for(int i = 0; i < V; i++){
            result.add(dist[i]);
        }
        return result;
    }
}
