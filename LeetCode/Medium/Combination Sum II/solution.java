class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

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
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > target){
                return;
            }
            curr.add(nums[i]);
            backtrack(curr, nums, target-nums[i], i+1);
            curr.remove(curr.size()-1);

        }
    }
}