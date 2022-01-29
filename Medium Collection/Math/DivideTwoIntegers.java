class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if(dividend < 0 && divisor > 0)
            sign = -1;
        if(dividend > 0 && divisor < 0)
            sign = -1;
        long dd = Math.abs((long) dividend);
        long ds = Math.abs((long) divisor);
        if(dd < ds)
            return 0;
        long count = 1L;
        long d = ds;
        while((d << 1) <= dd){
            d <<= 1;
            count <<= 1;
        }
        while(d + ds <= dd){
            d += ds;
            count++;
        }
        if(sign > 0){
            if(count > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int) count;
        } else{
            if(count > 1L + Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int)(-count);
        }
    }
}
