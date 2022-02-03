class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, i = 0;
        while(nums[i] > 0){
            nums[i] = -nums[i];
            i = -nums[i];
        }
        int ans = i;
        for(i = 0; i < n; i++)
            nums[i] = Math.abs(nums[i]);
        return ans;
    }
}
