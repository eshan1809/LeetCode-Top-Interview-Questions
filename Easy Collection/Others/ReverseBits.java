public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0, j = 0;
        for(int i = 31; i >= 0; i--){
            if((n & (1 << i)) != 0)
                ans |= (1 << j);
            j++;
        }
        return ans;
    }
}
