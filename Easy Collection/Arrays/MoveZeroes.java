class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0, n = nums.length;
        for(int i = 0; i < n; i++)
            if(nums[i] != 0)
                nums[idx++] = nums[i];
        for(int i = idx; i < n; i++)
            nums[i] = 0;
    }
}
