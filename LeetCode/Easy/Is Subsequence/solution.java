class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        return solve(s, t,n, m, 0, 0);
    }
    public boolean solve(String s, String t, int n, int m,  int i, int j){
        if(i == n){
            return true;
        }
        if(j == m){
            return false;
        }
        if(s.charAt(i) == t.charAt(j)){
            return solve(s, t, n, m, i+1, j+1);
        }
        else{
            return solve(s, t, n, m ,i, j+1);
        }
    }
}