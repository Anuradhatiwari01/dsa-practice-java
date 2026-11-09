
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int n = arrival.length;

        int[] count = new int[k];

        // Available servers
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Min heap: {finishTime, serverIndex}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < n; i++) {

            // Release servers whose requests are completed
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {

                int[] server = busy.poll();
                available.add(server[1]);
            }

            // If no server is available, drop the request
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server index
            int preferred = i % k;

            // Find the smallest available server >= preferred
            Integer server = available.ceiling(preferred);

            // Wrap around if necessary
            if (server == null) {
                server = available.first();
            }

            // Assign request to server
            available.remove(server);

            count[server]++;

            // Mark server as busy
            busy.offer(new int[]{
                arrival[i] + load[i],
                server
            });
        }

        // Find maximum number of requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Collect all servers with maximum requests
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
