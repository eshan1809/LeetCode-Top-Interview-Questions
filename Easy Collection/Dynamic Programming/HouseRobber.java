class Solution {
    public int rob(int[] nums) {
        int ps = nums[0], pns = 0;
        for(int i = 1; i < nums.length; i++){
            int cs = nums[i] + pns;
            pns = Math.max(ps, pns);
            ps = cs;
        }
        return Math.max(ps, pns);
    }
}
