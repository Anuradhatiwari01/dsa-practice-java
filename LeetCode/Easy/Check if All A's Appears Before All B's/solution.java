class Solution {
    public boolean checkString(String s) {
        int leftB = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'b'){
                leftB++;
            }
            if(s.charAt(i) == 'a' && leftB != 0){
                return false;
            }
        }
        return true;
    }
}