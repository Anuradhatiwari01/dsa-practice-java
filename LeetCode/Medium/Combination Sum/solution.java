class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(new ArrayList<>(), candidates, target, 0);

        return result;
    }
    public void backtrack(List<Integer>curr, int[]nums, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(curr, nums, target-nums[i], i);
            curr.remove(curr.size()-1);
        }
    }
}