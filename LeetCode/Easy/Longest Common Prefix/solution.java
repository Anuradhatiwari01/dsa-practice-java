class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int length = strs[0].length();

        for(int i = 1; i < strs.length; i++){
            String s = strs[i];

            while(length > s.length() || !prefix.equals(s.substring(0, length))){
                length--;
                if(length == 0){
                    return "";
                }
                prefix = prefix.substring(0, length);
            }
        }
        return prefix;
    }
}