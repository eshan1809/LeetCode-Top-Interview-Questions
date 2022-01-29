class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        long p = n;
        if(p < 0){
            x = 1 / x;
            p = -p;
        }
        return pow(x, p);
    }
    
    private double pow(double x, long n){
        if(x == 1)
            return 1.0;
        if(x == -1){
            if((n & 1L) == 0)
                return 1.0;
            return -1.0;
        }
        if(n == 1)
            return x;
        double ans = pow(x, n / 2);
        ans *= ans;
        if((n & 1L) == 1)
            ans *= x;
        return ans;
    }
}
