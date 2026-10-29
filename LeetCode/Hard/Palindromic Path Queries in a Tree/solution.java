import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        int LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[] head = new int[n];
        Arrays.fill(head, -1);

        int m = edges.length;
        int[] to = new int[2 * m];
        int[] next = new int[2 * m];

        int idx = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            to[idx] = v;
            next[idx] = head[u];
            head[u] = idx++;

            to[idx] = u;
            next[idx] = head[v];
            head[v] = idx++;
        }

        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] depth = new int[n];
        int[] parent = new int[n];
        int[] cur = new int[n];
        int[][] up = new int[LOG][n];

        Arrays.fill(parent, -1);
        System.arraycopy(head, 0, cur, 0, n);

        int[] stack = new int[n];
        int top = 0;
        int timer = 0;

        stack[top++] = 0;
        parent[0] = 0;
        tin[0] = timer++;

        for (int k = 0; k < LOG; k++) {
            up[k][0] = 0;
        }

        while (top > 0) {
            int u = stack[top - 1];
            int e = cur[u];

            while (e != -1 && to[e] == parent[u]) {
                e = next[e];
            }

            cur[u] = e;

            if (e == -1) {
                tout[u] = timer - 1;
                top--;
                continue;
            }

            cur[u] = next[e];

            int v = to[e];

            parent[v] = u;
            depth[v] = depth[u] + 1;
            tin[v] = timer++;

            up[0][v] = u;

            for (int k = 1; k < LOG; k++) {
                up[k][v] = up[k - 1][up[k - 1][v]];
            }

            stack[top++] = v;
        }

        Fenwick bit = new Fenwick(n + 1);
        char[] chars = s.toCharArray();

        for (int u = 0; u < n; u++) {
            int mask = 1 << (chars[u] - 'a');

            bit.update(tin[u], mask);
            bit.update(tout[u] + 1, mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split("\\s+");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                if (chars[u] == c) {
                    continue;
                }

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');
                int diff = oldMask ^ newMask;

                bit.update(tin[u], diff);
                bit.update(tout[u] + 1, diff);

                chars[u] = c;

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int w = lca(u, v, depth, up, LOG);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (chars[w] - 'a'));

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private int lca(int u, int v, int[] depth, int[][] up, int LOG) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = LOG - 1; k >= 0; k--) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    private static class Fenwick {
        private final int[] tree;

        Fenwick(int n) {
            tree = new int[n + 1];
        }

        void update(int index, int value) {
            for (int i = index + 1; i < tree.length; i += i & -i) {
                tree[i] ^= value;
            }
        }

        int query(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}