class Solution {
    public boolean isHappy(int n) {
        int s = helper(n), f = helper(s);
        while(true){
            if(s == f)
                break;
            s = helper(s);
            f = helper(helper(f));
        }
        return s == 1;
    }
    
    private int helper(int n){
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }
}
