class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(new ArrayList<>(), k, n, 1);
        return result;
    }
    public void backtrack(List<Integer> curr, int k, int n, int start){
        if(n == 0 && curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(n < 0){
            return;
        }
        for(int i = start; i <= 9; i++){
            if(curr.size() < k){
                curr.add(i);
                backtrack(curr, k , n - i, i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
}