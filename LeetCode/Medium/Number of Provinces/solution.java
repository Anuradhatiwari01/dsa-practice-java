
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int component = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isConnected[i][j] == 1) {
                    int rootA = find(parent, i);
                    int rootB = find(parent, j);

                    if (rootA != rootB) {
                        if (size[rootA] < size[rootB]) {
                            int temp = rootA;
                            rootA = rootB;
                            rootB = temp;
                        }

                        parent[rootB] = rootA;
                        size[rootA] += size[rootB];

                        component--;
                    }
                }
            }
        }

        return component;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
