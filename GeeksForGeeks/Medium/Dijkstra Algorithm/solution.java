class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
       ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
       
        for(int i = 0; i < V; i++){
           adj.add(new ArrayList<>());
        }
    
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        int[] weight = new int[V];
        Arrays.fill(weight, Integer.MAX_VALUE);
        
        weight[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
            
        pq.offer(new int[]{0, src});
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            
            int w = node[0];
            int u = node[1];
            
            if(weight[u] < w){
                continue;
            }
            
            for(int[] v : adj.get(u)){
                
                int neig = v[0];
                int wei = v[1];
                
                int newW = w + wei;
                
                if(newW < weight[neig]){
                    weight[neig] = newW;
                    
                    pq.offer(new int[]{newW, neig});
                }
                
            }
            
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < V; i++){
            result.add(weight[i]);
        }
        return result;
    }
}





