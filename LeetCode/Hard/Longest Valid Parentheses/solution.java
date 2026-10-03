class Solution {
    public int longestValidParentheses(String s) {

        int n = s.length();
        int[] dp = new int[n];

        int ans = 0;

        for (int i = 1; i < n; i++) {

            // Case 1: "()"
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {

                dp[i] = 2;

                if (i >= 2) {
                    dp[i] += dp[i - 2];
                }
            }

            // Case 2: "(())" or "()(())"
            else if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {

                int openIndex = i - dp[i - 1] - 1;

                if (openIndex >= 0 && s.charAt(openIndex) == '(') {

                    dp[i] = dp[i - 1] + 2;

                    if (openIndex >= 1) {
                        dp[i] += dp[openIndex - 1];
                    }
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}