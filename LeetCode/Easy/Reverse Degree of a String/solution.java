class Solution {
    public int reverseDegree(String s) {
        int degreeSum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int val = 'z' - c + 1;

            degreeSum += val *(i+1);
        }
        return degreeSum;
    }
}