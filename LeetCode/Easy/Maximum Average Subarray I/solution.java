class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;

        int i = 0;
        int sum = 0;

        for(int j = 0; j < nums.length; j++){
            sum+= nums[j];

            if(j-i+1 > k){
                sum -= nums[i];
                i++;
            }
            if(j-i+1 == k){
                maxValue = Math.max(maxValue, sum);
            }
            
        }
        return (double)maxValue/k;
    }
}