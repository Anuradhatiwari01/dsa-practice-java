class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int length = 0;

        int i = 0;
        for(int j = 0; j < s.length(); j++){

            if(set.contains(s.charAt(j))){
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            
            set.add(s.charAt(j));
            length = Math.max(length, j - i + 1);
        }
        return length;
    }
}