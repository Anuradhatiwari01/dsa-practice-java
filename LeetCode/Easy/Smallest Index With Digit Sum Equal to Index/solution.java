class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int sum = digitSum(nums[i]);
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
    public int digitSum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit;
            n = n /10;
        }
        return sum;
    }
}