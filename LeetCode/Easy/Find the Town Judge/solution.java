class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : trust){
            int u = t[0];
            int v = t[1];

            adj.get(u).add(v);
        }
        for(int i = 1; i <= n ; i++){
            if(adj.get(i).size() == 0){
                boolean isJudge = true;

                for(int j = 1; j <= n; j++){
                    if(i == j){
                        continue;
                    }
                    else if(!adj.get(j).contains(i)){
                        isJudge = false;
                    }
                }
                if(isJudge){
                    return i;
                }
            }
        }
        return -1;
    }
}