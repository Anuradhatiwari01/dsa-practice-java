class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int operations = n;

        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edges : connections){
            int u = edges[0];
            int v = edges[1];

            int rootu = find(parent, u);
            int rootv = find(parent, v);

            if(rootu == rootv){
                continue;
            }
            else if(size[rootu] < size[rootv]){
                int temp = rootu;
                rootu = rootv;
                rootv = temp;
            }
            parent[rootv] = rootu;
            size[rootu] += size[rootv];
            operations--;
        }
        return operations-1;
    }

    public int find(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}