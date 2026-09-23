class Solution {
    public int minOperations(int[] nums, int x) {
        int totalsum = 0;
        for(int val : nums){
            totalsum += val;
        }
        if(totalsum < x){
            return -1;
        }
        
        int n = totalsum - x;

        if(n == 0){
            return nums.length;
        }

        int maxlength = -1;
        int sum = 0;

        int i = 0;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];

            while(sum > n){
                sum -= nums[i];
                i++;
            }
            if(sum == n){
                maxlength = Math.max(j-i+1, maxlength);
            }
        }
        if(maxlength == -1){
            return -1;
        }
        else{
            return nums.length - maxlength;
        }
    }
}