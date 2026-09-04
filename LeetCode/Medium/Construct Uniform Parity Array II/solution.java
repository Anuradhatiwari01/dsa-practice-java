class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;

        for(int num : nums1){
            if(num % 2 != 0){
                minOdd = Math.min(minOdd, num);
            }
        }
        if(minOdd == Integer.MAX_VALUE){
            return true;
        }
        for(int n : nums1){
            if(n % 2 == 0 && n < minOdd){
                return false;
            }
        }
        return true;
    }
}