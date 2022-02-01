class Solution {
    public int maxProfit(int[] prices) {
        int bsp = -prices[0], ssp = 0, csp = 0;
        for(int i = 0; i < prices.length; i++){
            int nbsp = Math.max(bsp, csp - prices[i]);
            int nssp = Math.max(ssp, bsp + prices[i]);
            int ncsp = Math.max(csp, ssp);
            bsp = nbsp;
            ssp = nssp;
            csp = ncsp;
        }
        return ssp;
    }
}
