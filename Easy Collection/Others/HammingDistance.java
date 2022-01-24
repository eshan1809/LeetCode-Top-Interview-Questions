class Solution {
    public int hammingDistance(int x, int y) {
        int xor = (x ^ y), count = 0;
        while(xor > 0){
            xor -= (xor & -xor);
            count++;
        }
        return count;
    }
}
