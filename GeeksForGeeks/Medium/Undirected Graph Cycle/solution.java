class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] nodes : edges) {
            int u = nodes[0];
            int v = nodes[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(adj, visited, i, -1)) {
                return true;
            }
        }

        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj,
                       boolean[] visited, int node, int parent) {

        visited[node] = true;

        for (int v : adj.get(node)) {
            if (v == parent) {
                continue;
            }

            if (visited[v]) {
                return true;
            }

            if (dfs(adj, visited, v, node)) {
                return true;
            }
        }

        return false;
    }
}