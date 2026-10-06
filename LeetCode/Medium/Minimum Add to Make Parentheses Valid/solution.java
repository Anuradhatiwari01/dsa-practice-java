class Solution {
    public int minAddToMakeValid(String s) {
        int moves = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }
            if(!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }
            else if(ch == ')' || stack.isEmpty()){
                moves++;
            }
            
        }
        return moves  + stack.size();
    }
}