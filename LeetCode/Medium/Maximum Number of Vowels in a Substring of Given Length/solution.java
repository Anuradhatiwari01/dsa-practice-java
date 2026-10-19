class Solution {
    public int maxVowels(String s, int k) {

        int maxVowels = 0;
        int count = 0;

        int i = 0;
        for(int j = 0; j < s.length(); j++){

            char ch = s.charAt(j);

            if(ch == 'a' || 
                ch == 'e' || 
                ch == 'i' || 
                ch == 'o' || 
                ch == 'u'){
                count++;
            }
            if(j-i+1 == k){
                maxVowels = Math.max(maxVowels, count);
                if(s.charAt(i) == 'a' || 
                    s.charAt(i) == 'e' || 
                    s.charAt(i) == 'i' || 
                    s.charAt(i) == 'o'|| 
                    s.charAt(i) == 'u' ){
                    count--;
                }
                i++;
            }
        }
        return maxVowels;
    }
}