class Solution {
    List<List<Integer>> powerSet = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, 0);
        return powerSet;
    }
    public void backtrack(ArrayList<Integer> power, int[] nums, int start){
        powerSet.add(new ArrayList<>(power));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            power.add(nums[i]);
            backtrack(power, nums, i+1);
            power.remove(power.size()-1);

        }
    }
}