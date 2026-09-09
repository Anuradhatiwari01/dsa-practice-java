class Solution {
    public double myPow(double x, int n) {
       
        int p = n;

        if(n < 0){
            p = -p;
            x = 1/x;
        }
        return power(x, p);
    }
    public double power(double x, int n){
         if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double half = power(x, n/2);

        if(n % 2 == 0){
            return half * half;
        }
        else{
            return half*half*x;
        }
    }
}