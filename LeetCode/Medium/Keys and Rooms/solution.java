class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] roomVisited = new boolean[n];
        dfs(rooms, n, roomVisited, 0);

        for(boolean v : roomVisited){
            if(!v){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, int n, boolean[] roomVisited, int i){
        roomVisited[i] = true;

        for(int v : rooms.get(i)){
            if(!roomVisited[v]){
                dfs(rooms, n, roomVisited, v);
            }
            
        }

    }
}