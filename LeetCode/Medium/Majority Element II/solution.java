class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int majority1 = nums[0];
        int majority2 = nums[0];
        
        int count1 = 0;
        int count2 = 0;
        
        for(int n: nums){
            if(majority1 == n){
                count1++;
            }
            else if(majority2 == n && n != majority1){
                count2++;
            }
            else if(count1 == 0){
                majority1 = n;
                count1++;
            }
            else if(count2 == 0){
                majority2 = n;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        
        for(int n : nums){
            if(majority1 == n){
                count1++;
            }
            else if(majority2 == n){
                count2++;
            }
        }
        if(count1 > nums.length/3){
            res.add(majority1);
        }
        if(count2 > nums.length/3){
            res.add(majority2);
        }
        return res;
        
    }
}