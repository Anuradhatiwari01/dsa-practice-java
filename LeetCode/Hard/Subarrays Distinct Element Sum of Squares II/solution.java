
class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(n);
        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last[x];

            // Add 1 to distinct counts of subarrays
            // ending at i, whose start is in [prev, i].
            seg.update(prev, i, 1);

            // Sum of squares of distinct counts
            ans = (ans + seg.queryAll()) % MOD;

            last[x] = i + 1;
        }

        return (int) ans;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] sq;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long val) {
            long len = r - l + 1L;

            // (x + val)^2 = x^2 + 2*val*x + val^2
            sq[node] = (sq[node]
                    + 2 * val % MOD * sum[node] % MOD
                    + len % MOD * val % MOD * val % MOD) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = (l + r) / 2;
            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);

            lazy[node] = 0;
        }

        void pull(int node) {
            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
        }

        void update(int ql, int qr, long val) {
            update(1, 0, n - 1, ql, qr, val);
        }

        void update(int node, int l, int r,
                    int ql, int qr, long val) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            if (ql <= mid)
                update(node * 2, l, mid, ql, qr, val);

            if (qr > mid)
                update(node * 2 + 1, mid + 1, r, ql, qr, val);

            pull(node);
        }

        long queryAll() {
            return sq[1];
        }
    }
}
