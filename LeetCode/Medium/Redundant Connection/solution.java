class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        int[] parent = new int[n+1];
        int[] size = new int[n+1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if(rootU == rootV){
                return edge;
            }
            if(size[rootU] < size[rootV]){
                int temp = rootU;
                rootU = rootV;
                rootV = temp;
            }
            parent[rootV] = rootU;
            size[rootU] += size[rootV];;
        }
        return new int[0];
    }
    public int find(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}