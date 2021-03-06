class Solution {
    public int climbStairs(int n) {
        if(n < 4)
            return n;
        int a = 1, b = 2;
        for(int i = 3; i < n; i++){
            b += a;
            a = b - a;
        }
        return a + b;
    }
}
