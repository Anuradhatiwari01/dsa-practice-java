class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
       ArrayList<Integer> result = new ArrayList<>();
       
       ArrayDeque<Integer> queue = new ArrayDeque<>();
       
       int n = adj.size();
       boolean[] visited = new boolean[n];
       
       queue.offer(0);
       visited[0] = true;
       
       while(!queue.isEmpty()){
           int node = queue.poll();
           
            for(int neigh : adj.get(node)){
                
                if(!visited[neigh]){
                    queue.offer(neigh);
                    visited[neigh] = true;
                }
            }
            result.add(node);
       }
       return result;
        
    }
}