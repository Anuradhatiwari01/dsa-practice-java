class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, 0);
        return result;
    }
    public void backtrack(ArrayList<Integer> curr, int[]nums, int start){
        result.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            backtrack(curr, nums, i+1);
            curr.remove(curr.size()-1);
        }
    }
}