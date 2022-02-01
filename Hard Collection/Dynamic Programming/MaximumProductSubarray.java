class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, max = nums[0], min = nums[0], res = nums[0];
        for(int i = 1; i < n; i++){
            int tmp = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(min * nums[i], max * nums[i]), nums[i]);
            max = tmp;
            res = Math.max(res, max);
        }
        return res;
    }
}
