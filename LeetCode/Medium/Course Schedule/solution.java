class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]p : prerequisites){
            int u = p[0];
            int v = p[1];

            adj.get(u).add(v);
        }
        int[] indegree = new int[numCourses+1];

        for(int i = 0; i <= numCourses; i++){
            for(int v : adj.get(i)){
                indegree[v]++;
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i <= numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int v : adj.get(node)){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        for(int i = 0; i <= numCourses; i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}