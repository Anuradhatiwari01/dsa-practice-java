class Solution {
    public int scoreOfParentheses(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(0);

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(0);
            }
            else{
                int inside = stack.pop();

                if(inside == 0){
                    stack.push(stack.pop() + 1);
                }
                else{
                    stack.push(stack.pop() + 2 * inside);
                }
            }
        }
        return stack.pop();
    }
}