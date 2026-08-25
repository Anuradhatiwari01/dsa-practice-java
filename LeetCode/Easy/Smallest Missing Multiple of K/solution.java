class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(nums[i] % k == 0){
                set.add(nums[i]);
            }
        }
        int i = 1;
        while(set.contains(i * k)){
            i++;
        }
        return i *k;
    }
}