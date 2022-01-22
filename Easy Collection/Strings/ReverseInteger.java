class Solution {
    public int reverse(int x) {
        long ans = 0L, sign = 1;
        if(x < 0){
            sign = -1;
            x *= -1;
        }
        while(x > 0){
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        ans *= sign;
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return 0;
        return (int)ans;
    }
}
