class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length; 
        int[] smaller = new int[n];
        int [] larger = new int[n];

        larger[0] = nums[0];
        int maxval = nums[0];

        for(int i = 1; i < n; i++){
            maxval = Math.max(nums[i], maxval);
            larger[i] = maxval;
        }
        smaller[n-1] = nums[n-1];
        int minval = nums[n-1];

        for(int i = n-1; i >= 0; i--){
            minval = Math.min(minval, nums[i]);
            smaller[i] = minval;
        }
        int samallerstidx = 0;

        for(int i = 0 ; i < n; i++){
            if((larger[i] - smaller[i]) <=k ){
                return i;
            }
        }
        return -1;
    }
}