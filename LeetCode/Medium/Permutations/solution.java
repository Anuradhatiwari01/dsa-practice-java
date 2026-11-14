class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        boolean[] isUsed = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, isUsed);
        return result;
    }

    public void backtrack(ArrayList<Integer> curr, int[]nums, boolean[] isUsed){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(isUsed[i] == true){
                continue;
            }
            curr.add(nums[i]);
            isUsed[i] = true;
            backtrack(curr, nums, isUsed);
            curr.remove(curr.size()-1);
            isUsed[i] = false;
        }
    }
}