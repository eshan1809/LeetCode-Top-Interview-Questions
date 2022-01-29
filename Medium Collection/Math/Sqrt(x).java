class Solution {
    public int mySqrt(int x) {
        int i = 0;
        while(1L * i * i < x)
            i++;
        if(1L * i * i > x)
            i--;
        return i;
    }
}
