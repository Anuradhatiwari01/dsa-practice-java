class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[]node = pq.poll();

            int wet = node[0];
            int nextnode = node[1];

            if(wet > dist[nextnode]){
                continue;
            }
            for(int[]v : adj.get(nextnode)){
                int neigh = v[0];
                int wei = v[1];

                if(wei + wet < dist[neigh]){
                    dist[neigh] = wei + wet;
                    pq.offer(new int[]{dist[neigh], neigh});
                }

            }
        }
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            result = Math.max(result, dist[i]);
        }
        return result;
    }
}