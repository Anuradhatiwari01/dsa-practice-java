class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(')');
            }
            else if(s.charAt(i) == '['){
                stack.push(']');
            }
            else if(s.charAt(i) == '{'){
                stack.push('}');
            }
            else{
                if(stack.isEmpty() || s.charAt(i) != stack.peek()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}