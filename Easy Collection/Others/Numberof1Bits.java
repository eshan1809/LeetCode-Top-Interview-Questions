public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        if(n < 0){
            count = 1;
            n = n ^ (1 << 31);
        }
        while(n > 0){
            n -= (n & -n);
            count++;
        }
        return count;
    }
}
